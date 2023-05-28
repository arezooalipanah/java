package com.moneytransfer.services;

import com.moneytransfer.core.AbstractService;

import com.moneytransfer.exceptions.ServiceException;
import com.moneytransfer.models.QAccount;
import com.moneytransfer.models.QTransaction;
import com.moneytransfer.models.Transaction;
import com.moneytransfer.repositories.TransactionRepository;
import com.moneytransfer.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService extends AbstractService<TransactionRepository, Transaction> {
    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private AccountService accountService;

    public List<Transaction> findByAccountIdAndTransactionDateBetween(Long accountId, String fromDateStr, String toDateStr) throws ServiceException{
        if (fromDateStr.isEmpty() || toDateStr.isEmpty()) {
            throw new ServiceException("FROM_DATE_AND_TO_DATE_BOTH_SHOULD_BE_PRESENT");
        }
        accountService.getAccountById(accountId);

        SimpleDateFormat sdFormat = new SimpleDateFormat("ddMMyyyy");
        Date fromDate;
        Date toDate;

        try {
            fromDate = sdFormat.parse(fromDateStr);
        } catch (ParseException e) {
            throw new ServiceException("FROM_DATE_SHOULD_BE_IN_DD_M_MYYYY_FORMAT_AS_QUERY_STRING");
        }

        try {
            toDate = sdFormat.parse(toDateStr);
        } catch (ParseException e) {
            throw new ServiceException("FROM_DATE_SHOULD_BE_IN_DD_M_MYYYY_FORMAT_AS_QUERY_STRING");
        }

        toDate = dateUtil.addDay(toDate, 1);
        QTransaction transaction = QTransaction.transaction;
        QAccount account = QAccount.account;
        List<Transaction> transactions = new ArrayList<>();

        repository.findAll(transaction.transactionDate.between(fromDate, toDate)
                        .and(account.id.eq(accountId))).forEach(transactions::add);
        return transactions;
    }
}
