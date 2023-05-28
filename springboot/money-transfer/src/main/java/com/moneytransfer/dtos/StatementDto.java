package com.moneytransfer.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class StatementDto {
    private String fromDate;
    private String toDate;
    private List<TransactionDto> transactions;
    private BigDecimal balance;
}
