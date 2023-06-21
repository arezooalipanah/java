package com.example.aop.terms;

import java.lang.annotation.Annotation;

public class App {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    CustomerService customerService = context.getBean(CustomerService.class);
    customerService.doSomeThing();

}
