package com.example.paymentta.convertors;

import com.example.paymentta.dto.CustomerDto;
import com.example.paymentta.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerConvertor implements BaseConverter<CustomerDto, CustomerEntity> {
    @Override
    public CustomerEntity convertDto(CustomerDto d) {
        CustomerEntity e = new CustomerEntity();
        e.setId(d.getId());
        e.setFirstName(d.getFirstName());
        e.setLastName(d.getLastName());
        e.setBalance(d.getBalance());
        e.setCardNumber(d.getCardNumber());
        e.setAge(d.getAge());
        return e;
    }

    @Override
    public CustomerDto convertEntity(CustomerEntity e) {
        CustomerDto d = new CustomerDto();
        d.setId(e.getId());
        d.setFirstName(e.getFirstName());
        d.setLastName(e.getLastName());
        d.setBalance(e.getBalance());
        d.setCardNumber(e.getCardNumber());
        d.setAge(e.getAge());
        return d;
    }
}
