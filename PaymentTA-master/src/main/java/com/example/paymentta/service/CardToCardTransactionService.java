package com.example.paymentta.service;

import com.example.paymentta.dto.CardDto;
import com.example.paymentta.entity.CustomerEntity;
import com.example.paymentta.entity.TransactionEntity;
import com.example.paymentta.entity.enums.TransactionType;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.TransactionRepository;
import com.example.paymentta.service.notifications.NotificationSender;
import com.example.paymentta.service.notifications.NotificationText;
import com.example.paymentta.service.notifications.NotificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service()
@Primary
public class CardToCardTransactionService extends AbstractService<TransactionRepository, TransactionEntity> implements BaseTransaction<CardDto> {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private NotificationSender notificationSender;


    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void resolveTransaction(CardDto d) throws ServiceException {

        CustomerEntity sender = customerService.withdraw(d.getSendCardNumber(), d.getAmount(), TransactionType.CARDTOCARD);

        if (sender == null) {
            throw new ServiceException(" your balance is not enough");
        }

        CustomerEntity receiver = customerService.deposit(d.getReceiverCardNumber(), d.getAmount(), TransactionType.CARDTOCARD);

        if (receiver == null) {
            throw new ServiceException("receiver card number is not valid ");
        }

        TransactionEntity trxEntity = new TransactionEntity();
        trxEntity.setReceiver(receiver);
        trxEntity.setSender(sender);
        trxEntity.setDate(new Date());
        trxEntity.setTransactionType(TransactionType.CARDTOCARD);
        trxEntity.setAmount(d.getAmount());

        transactionRepository.save(trxEntity);

        notificationSender.send(NotificationType.EMAIL, new NotificationText("kasr ", sender.getCardNumber(), d.getAmount(), trxEntity.getDate()));
        notificationSender.send(NotificationType.SMS, new NotificationText("plus", receiver.getCardNumber(), d.getAmount(), trxEntity.getDate()));
    }

}
