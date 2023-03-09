package com.example.paymentta.convertors;

import com.example.paymentta.dto.BaseTransactionDto;
import com.example.paymentta.dto.CustomerDto;
import com.example.paymentta.entity.CustomerEntity;
import com.example.paymentta.entity.TransactionEntity;
import com.example.paymentta.service.BaseTransaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionConvertor implements BaseConverter<BaseTransactionDto, TransactionEntity> {
    @Override
    public TransactionEntity convertDto(BaseTransactionDto d) {
        TransactionEntity e = new TransactionEntity();
        e.setDate(d.getDate());
        e.setAmount(d.getAmount());
        return e;
    }

    @Override
    public BaseTransactionDto convertEntity(TransactionEntity e) {
        BaseTransactionDto d = new BaseTransactionDto();
        d.setDate(e.getDate());
        d.setAmount(e.getAmount());
        return d;
    }
}
