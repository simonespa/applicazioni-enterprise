package ae.spring.aop.advice;

import java.util.Arrays;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor
{
    public Object invoke(final MethodInvocation methodInvocation) throws Throwable
    {
        // prima dell'invocazione del metodo
        System.out.println("[" + new Date() + "]\n\t" + methodInvocation.getThis().getClass() + "."
                + methodInvocation.getMethod().getName() + "\n\tArgomenti: " + Arrays.toString(methodInvocation.getArguments()));

        Object result = null;
        try
        {
            // invocazione metodo	
            result = methodInvocation.proceed();
        }
        catch (final Exception ex)
        {
            // eccezione ritornata dal metodo
            System.out.println("\tErrore: " + ex.getMessage());
        }

        // risultato dell'invocazione del metodo
        System.out.println("\tRisultato: " + result);

        return result;
    }

}
