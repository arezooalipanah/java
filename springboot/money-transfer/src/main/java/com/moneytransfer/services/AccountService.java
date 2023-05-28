package com.moneytransfer.services;

import com.moneytransfer.core.AbstractService;
import com.moneytransfer.dtos.CreateAccountDto;
import com.moneytransfer.dtos.CreateTransferDto;
import com.moneytransfer.enums.TransactionType;
import com.moneytransfer.exceptions.IdNotFoundException;
import com.moneytransfer.exceptions.InvalidAccountException;
import com.moneytransfer.exceptions.ServiceException;
import com.moneytransfer.models.Account;
import com.moneytransfer.models.Transaction;
import com.moneytransfer.repositories.AccountRepository;
import com.moneytransfer.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
public class AccountService extends AbstractService<AccountRepository, Account> {
    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private TransactionService transactionService;

    @Transactional
    public void createNew(CreateAccountDto accountDto) throws ServiceException {
        Account account = Account.builder()
                .balance(accountDto.getBalance())
                .name(accountDto.getName())
                .openDate(dateUtil.getNow()).build();

        if (account == null || account.getId() != null || account.getBalance().compareTo(new BigDecimal(0)) <= 0) {
            throw new InvalidAccountException("ACCOUNT_OBJECT_IS_INVALID");
        }

        Date openDate = dateUtil.getNow();
        account.setOpenDate(openDate);

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setTransactionAmount(account.getBalance());
        transaction.setBalance(account.getBalance());
        transaction.setTransactionDate(openDate);
        transaction.setTransactionType(TransactionType.IN);
        transaction.setCounterparty("INITIAL DEPOSIT");

        account.getTransactions().add(transaction);

        try {
            transactionService.add(transaction);
            add(account);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public Account getAccountById(Long id) throws ServiceException {
        Optional<Account> accountOpt = findById(id);
        if (!accountOpt.isPresent()) {
            throw new IdNotFoundException("ID_NOT_FOUND");
        }

        return accountOpt.get();
    }

    @Transactional
    public void transfer(Long fromAccountId, CreateTransferDto transferDto) throws ServiceException {
        Account fromAccount = getAccountById(fromAccountId);
        Account toAccount = getAccountById(transferDto.getToAccountId());
        BigDecimal amount = transferDto.getAmount();

        if (fromAccount == null || toAccount == null || transferDto.getAmount().compareTo(new BigDecimal(0)) <= 0) {
            throw new InvalidAccountException("FROM_ACCOUNT_AND_TO_ACCOUNT_SHOULD_NOT_BE_NULL_AND_TRANSFER_AMOUNT_SHOULD_BE_GREATER_THAN_0");
        }
        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new InvalidAccountException("FROM_ACCOUNT_DOES_NOT_CONTAIN_SUFFICIENT_FUNDS");
        }

        if (fromAccountId.equals(transferDto.getToAccountId())) {
            throw new InvalidAccountException("FROM_ACCOUNT_ID_AND_TO_ACCOUNT_ID_CANNOT_BE_SAME");
        }

        Date txDate = dateUtil.getNow();
        BigDecimal fromAccountBalance = fromAccount.getBalance().subtract(amount);
        fromAccount.setBalance(fromAccountBalance);
        BigDecimal toAccountBalance = toAccount.getBalance().add(amount);
        toAccount.setBalance(toAccountBalance);

        // transaction for fromAccount
        Transaction fromAccountTransaction = new Transaction();
        fromAccountTransaction.setAccount(fromAccount);
        fromAccountTransaction.setTransactionAmount(amount);
        fromAccountTransaction.setBalance(fromAccountBalance);
        fromAccountTransaction.setTransactionDate(txDate);
        fromAccountTransaction.setTransactionType(TransactionType.OUT);
        fromAccountTransaction.setCounterparty(toAccount.getId().toString());

        // transaction for toAccount
        Transaction toAccountTransaction = new Transaction();
        toAccountTransaction.setAccount(toAccount);
        toAccountTransaction.setTransactionAmount(amount);
        toAccountTransaction.setBalance(toAccountBalance);
        toAccountTransaction.setTransactionDate(txDate);
        toAccountTransaction.setTransactionType(TransactionType.IN);
        toAccountTransaction.setCounterparty(fromAccount.getId().toString());

        fromAccount.getTransactions().add(fromAccountTransaction);
        toAccount.getTransactions().add(toAccountTransaction);

        try {
            transactionService.add(fromAccountTransaction);
            transactionService.add(toAccountTransaction);
            add(fromAccount);
            add(toAccount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
