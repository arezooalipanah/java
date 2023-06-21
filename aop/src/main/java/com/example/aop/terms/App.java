package com.example.aop.terms;

import java.lang.annotation.Annotation;

public class App {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    CustomerService customerService = context.getBean(CustomerService.class);
    customerService.doSomeThing();
    customerService.getName();
    customerService.getAge();
    double payment = customerService.calculatePayment(20, 5);
    System.out.println(payment)

    AccountService accountService = context.getBesn(AccountService.class);
    accountService.deposit(10.00)

}
