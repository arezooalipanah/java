package com.example.paymentta.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BaseTransactionDto {
    private Date date;
    private Long amount;
}
