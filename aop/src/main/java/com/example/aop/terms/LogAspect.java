package com.example.aop.terms;

@Aspect
@Component
public class LogAspect {
    @Before("execution(* *(..))")
    public void logBefore() {
        System.out.println("logging before method being executed...");
    }

    @After("execution(* *(..))")
    public void logBefore() {
        System.out.println("logging after method being executed...");
    }
}
