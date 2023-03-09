package com.example.paymentta.entity;

import com.example.paymentta.entity.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class TransactionEntity extends AbstractEntity {
    private Date date;
    private Long amount;
    private TransactionType transactionType;
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private CustomerEntity sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private CustomerEntity receiver;
}
