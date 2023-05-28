package com.moneytransfer.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTransferDto {
    private Long toAccountId;
    private BigDecimal amount;
}
