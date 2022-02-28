package ae.spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MyAfterReturningAdvice implements AfterReturningAdvice
{

    public void afterReturning(final Object returnValue, final Method method, final Object[] args, final Object target)
            throws Throwable
    {
        System.out.println("\tRisultato: " + returnValue);
    }

}
