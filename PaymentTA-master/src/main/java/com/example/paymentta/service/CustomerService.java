package com.example.paymentta.service;


import com.example.paymentta.dto.CustomerDto;
import com.example.paymentta.entity.CustomerEntity;
import com.example.paymentta.convertors.CustomerConvertor;
import com.example.paymentta.entity.enums.TransactionType;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerService extends AbstractService<CustomerRepository, CustomerEntity> {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerConvertor customerConvertor;

    public void insert(CustomerDto customer) {
        /*todo: add validation*/
        CustomerEntity cm = customerConvertor.convertDto(customer);
        cm.setInsertTimestamp(new Date());
        customerRepository.save(cm);
    }

    public CustomerEntity getById(Long id) throws ServiceException {
        Optional<CustomerEntity> customer = customerRepository.findById(id);

        try {
            return customer.orElseThrow();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), "user not Found");
        }
    }

    public CustomerEntity withdraw(String customerAccount, Long amount, TransactionType type) {
        CustomerEntity c = switch (type) {
            case CARDTOCARD -> customerRepository.findByCardNumber(customerAccount);
            case ACCOUNTNUMBER -> customerRepository.findByAccountNumber(customerAccount);
        };

        if (c != null && amount < c.getBalance()) {
            c.setBalance(c.getBalance() - amount);
            customerRepository.save(c);
            return c;
        }
        return null;
    }

    public CustomerEntity deposit(String customerAccount, Long amount, TransactionType type) {
        CustomerEntity c = switch (type) {
            case CARDTOCARD -> customerRepository.findByCardNumber(customerAccount);
            case ACCOUNTNUMBER -> customerRepository.findByAccountNumber(customerAccount);
        };

        if (c != null) {
            c.setBalance(c.getBalance() + amount);
            customerRepository.save(c);
            return c;
        }
        return null;
    }

    public Long accountBalance(String cardNumber) throws ServiceException {
        CustomerEntity customer = customerRepository.findByCardNumber(cardNumber);
        if (customer != null) {
            return customer.getBalance();
        } else {
            throw new ServiceException("user_not_found");
        }
    }

    public void update(CustomerDto customerDto) throws ServiceException {
        CustomerEntity customer = customerRepository.findById(customerDto.getId())
                .orElseThrow(() -> new ServiceException("customer not found"));

        change(customer, customerDto);
        customerRepository.save(customer);
    }

    private void change(CustomerEntity customer, CustomerDto customerDto) {
        if (customerDto.getCardNumber() != null) customer.setCardNumber(customerDto.getCardNumber());
        if (customerDto.getAge() != null) customer.setAge(customerDto.getAge());
        if (customerDto.getBalance() != null) customer.setBalance(customerDto.getBalance());
        if (customerDto.getFirstName() != null) customer.setFirstName(customerDto.getFirstName());
        if (customerDto.getLastName() != null) customer.setLastName(customerDto.getLastName());
    }
}
