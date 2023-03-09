package com.example.paymentta.service;

import com.example.paymentta.dto.AccountDto;
import com.example.paymentta.dto.BaseTransactionDto;
import com.example.paymentta.dto.CardDto;
import com.example.paymentta.entity.TransactionEntity;
import com.example.paymentta.entity.enums.TransactionType;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService extends AbstractService<TransactionRepository, TransactionEntity> {
    // solution one
//    @Autowired
//    private CardToCardTransactionService ca;
//
//    @Autowired
//    private AccountTransactionService ac;
//
//    public void doTransfer(TransactionType method, BaseTransactionDto dto) throws ServiceException {
//        if (method == TransactionType.CARDTOCARD) {
//            ca.resolveTransaction((CardDto) dto);
//        }
//
//        if (method == TransactionType.ACCOUNTNUMBER) {
//            ac.resolveTransaction((AccountDto) dto);
//        }
//    }

    // solution two
    @Autowired
    private List<BaseTransaction<? extends BaseTransactionDto>> list;

    public BaseTransaction getTransactionMethod(TransactionType method) {
        for (BaseTransaction<? extends BaseTransactionDto> t : list) {
            if (method == TransactionType.CARDTOCARD && t instanceof CardToCardTransactionService) {
                return t;
            }

            if (method == TransactionType.ACCOUNTNUMBER && t instanceof AccountTransactionService) {
                return t;
            }
        }
        return null;
    }
}
