package com.moneytransfer.controllers;

import com.moneytransfer.core.AbstractController;
import com.moneytransfer.dtos.AccountDto;
import com.moneytransfer.dtos.CreateAccountDto;
import com.moneytransfer.dtos.CreateTransferDto;
import com.moneytransfer.exceptions.ServiceException;
import com.moneytransfer.models.Account;
import com.moneytransfer.services.AccountService;
import jakarta.annotation.PostConstruct;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController extends AbstractController<Account, AccountDto> {
    private AccountService accountService;

    @PostConstruct
    public void init() {
        accountService = (AccountService) this.service;
    }

    @PostMapping("/open")
    public void postAccount(@RequestBody CreateAccountDto createDto) throws ServiceException {
        accountService.createNew(createDto);
    }

    @PostMapping("/{fromAccountId}/transfer")
    public void transferAmount(@PathVariable("fromAccountId") Long fromAccountId, @RequestBody CreateTransferDto transferDto) throws ServiceException {
        try {
            accountService.transfer(fromAccountId, transferDto);
        } catch (OptimisticLockingFailureException ex) {
            throw new ServiceException("MONEY_TRANSFER_TRANSACTION_FAILED_PLEASE_TRY_AGAIN");
        }
    }
}