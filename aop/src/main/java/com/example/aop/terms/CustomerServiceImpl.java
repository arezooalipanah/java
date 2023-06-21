package com.example.aop.terms;

@Component
public class CustomerServiceImpl implements CustomerService {
    public void doSomething() {
        System.out.println("do something in customerServiceImpl..");
    }

    public String getName() {
        return "arezooo";
    }

    public String getAge() {
        throw  new MyException("my exception..");
    }

    @Override
    public double calculatePayment(double rate, int hours) {
        System.out.println("rate: " + rate + ", hours: " + hours);
        return rate * hours;
    }
}
