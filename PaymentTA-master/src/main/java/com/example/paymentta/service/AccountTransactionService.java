package com.example.paymentta.service;

import com.example.paymentta.dto.AccountDto;
import com.example.paymentta.entity.CustomerEntity;
import com.example.paymentta.entity.TransactionEntity;
import com.example.paymentta.entity.enums.TransactionType;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.TransactionRepository;

import com.example.paymentta.service.notifications.NotificationSender;
import com.example.paymentta.service.notifications.NotificationText;
import com.example.paymentta.service.notifications.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service()
public class AccountTransactionService extends AbstractService<TransactionRepository, TransactionEntity> implements BaseTransaction<AccountDto>{
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private NotificationSender notificationSender;


    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void resolveTransaction(AccountDto dto) throws ServiceException {

        CustomerEntity sender = customerService.withdraw(dto.getSendAccountNumber(), dto.getAmount(), TransactionType.ACCOUNTNUMBER);

        if (sender == null) {
            throw new ServiceException(" your balance is not enough");
        }

        CustomerEntity receiver = customerService.deposit(dto.getReceiverAccountNumber(), dto.getAmount(), TransactionType.ACCOUNTNUMBER);

        if (receiver == null) {
            throw new ServiceException("receiver card number is not valid ");
        }

        TransactionEntity trxEntity= new TransactionEntity();
        trxEntity.setReceiver(receiver);
        trxEntity.setSender(sender);
        trxEntity.setDate(new Date());
        trxEntity.setTransactionType(TransactionType.ACCOUNTNUMBER);
        trxEntity.setAmount(dto.getAmount());

        transactionRepository.save(trxEntity);

        notificationSender.send(NotificationType.EMAIL, new NotificationText("kasr ", sender.getCardNumber(), dto.getAmount(), trxEntity.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("plus", receiver.getCardNumber(), dto.getAmount(), trxEntity.getDate()));
    }
}
