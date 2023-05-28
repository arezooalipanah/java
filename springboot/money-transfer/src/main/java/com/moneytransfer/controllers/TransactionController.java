package com.moneytransfer.controllers;

import com.moneytransfer.core.AbstractController;
import com.moneytransfer.dtos.TransactionDto;
import com.moneytransfer.exceptions.ServiceException;
import com.moneytransfer.models.Transaction;
import com.moneytransfer.services.TransactionService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransactionController extends AbstractController<Transaction, TransactionDto> {
    private TransactionService transactionService;

    @PostConstruct
    public void init() {
        transactionService = (TransactionService) this.service;
    }


    // "/account/{id}/statement?fromDate={fromDateStr}&toDate={toDateStr}"
    @GetMapping(path = "/{id}/statement")
    public List<Transaction> generateStatement(final @PathVariable Long id,
                                               final @RequestParam("fromDate") String fromDateStr,
                                               final @RequestParam("toDate") String toDateStr) throws ServiceException {

        return transactionService.findByAccountIdAndTransactionDateBetween(id, fromDateStr, toDateStr);
    }
}