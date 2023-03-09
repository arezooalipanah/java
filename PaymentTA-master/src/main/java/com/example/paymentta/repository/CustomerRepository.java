package com.example.paymentta.repository;

import com.example.paymentta.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByCardNumber(String cardNumber);
    CustomerEntity findByAccountNumber(String accountNumber);
}
