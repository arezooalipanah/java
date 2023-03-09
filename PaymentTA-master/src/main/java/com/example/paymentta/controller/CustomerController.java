package com.example.paymentta.controller;


import com.example.paymentta.dto.CustomerDto;
import com.example.paymentta.entity.CustomerEntity;
import com.example.paymentta.exceptions.ServiceException;
import com.example.paymentta.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController extends AbstractController<CustomerEntity, CustomerDto> {
//    @Autowired
//    private CustomerService customerService;
//
//    @GetMapping("card/{cardNumber}")
//    public long getBalance(@PathVariable("cardNumber") String card) throws ServiceException {
//        return customerService.accountBalance(card);
//    }
}
