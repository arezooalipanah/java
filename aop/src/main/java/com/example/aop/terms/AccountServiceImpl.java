package com.example.aop.terms;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void deposit(double amount) {
        System.out.println("Deposit successfully" + amount);
    }
}
