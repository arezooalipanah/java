package com.example.paymentta.controller;

import com.example.paymentta.dto.AccountDto;
import com.example.paymentta.dto.BaseTransactionDto;
import com.example.paymentta.dto.CardDto;
import com.example.paymentta.entity.TransactionEntity;
import com.example.paymentta.entity.enums.TransactionType;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.BaseTransaction;
import com.example.paymentta.service.CardToCardTransactionService;
import com.example.paymentta.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransactionController extends AbstractController<TransactionEntity, BaseTransactionDto> {
    // one solution
//    @Autowired
//    private TransactionService transactionService;

//    @PostMapping("/by-card")
//    public void transaction(@RequestBody CardDto d) throws ServiceException {
//        transactionService.doTransfer(TransactionType.CARDTOCARD, d);
//    }
//
//    @PostMapping("/by-account")
//    public void transaction(@RequestBody AccountDto d) throws ServiceException {
//        transactionService.doTransfer(TransactionType.ACCOUNTNUMBER, d);
//    }

    // two solution
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/by-card")
    public void transaction(@RequestBody CardDto cardDto) throws ServiceException {
        transactionService.getTransactionMethod(TransactionType.CARDTOCARD).resolveTransaction(cardDto);
    }

    @PostMapping("/by-account")
    public void transaction(@RequestBody AccountDto accountDto) throws ServiceException {
        transactionService.getTransactionMethod(TransactionType.ACCOUNTNUMBER).resolveTransaction(accountDto);
    }
}
