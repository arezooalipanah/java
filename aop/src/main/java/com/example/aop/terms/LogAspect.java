package com.example.aop.terms;

@Aspect
@Component
public class LogAspect {
    @Before("execution(* *(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("logging before method being executed..." + joinPoint.getSignature().getName());
        System.out.println(joinPoint.getTarget().getClass().getName());
        System.out.println(joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getThis().getClass().getName());
    }

    @After("execution(* com.example.aop.terms.CustomerService.*(..))")
    public void logAfter() {
        System.out.println("logging after method being executed...");
    }

    @AfterReturning(pointcut = "execution(* *(..))", returning = "myname")
    public void logAfterReturning(String myname) {
        System.out.println("Return value" + myname);
    }

    @AfterThrowing(pointcut = "execution(* getAge(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, MyException ex) {
        System.out.println(joinPoint.getSingnature().getName() + "throw exception" + ex.getMsg());
    }

    @Around("execution(* com.example.aop.terms.CustomerService.calculatePayment(double, int))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("Args in Around Advice: " + args[0] + "," + args[1]);

        args[0]= 30;
        args[1] = 9;

        Object result = null;
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        System.out.println("Result in Around Advice: " + result);

        return result;
    }
}
