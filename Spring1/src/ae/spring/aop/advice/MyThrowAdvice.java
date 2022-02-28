package ae.spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowAdvice implements ThrowsAdvice
{
    public void afterThrowing(final Exception e) throws Throwable
    {
        System.out.println("\tErrore: " + e.getMessage());
    }

}
