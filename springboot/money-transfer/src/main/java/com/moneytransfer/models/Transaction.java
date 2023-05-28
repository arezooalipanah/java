package com.moneytransfer.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.moneytransfer.core.AbstractEntity;
import com.moneytransfer.enums.TransactionType;
import jakarta.persistence.Entity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Transaction extends AbstractEntity {
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private BigDecimal transactionAmount;

    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private String counterparty;
}
