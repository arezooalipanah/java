package com.moneytransfer.dtos;

import com.moneytransfer.core.AbstractDto;
import com.moneytransfer.enums.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionDto extends AbstractDto {
    private Date transactionDate;
    private TransactionType transactionType;
    private BigDecimal transactionAmount;
    private BigDecimal balance;
    private String counterparty;
}
