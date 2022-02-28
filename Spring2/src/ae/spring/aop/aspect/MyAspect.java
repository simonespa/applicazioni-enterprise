package ae.spring.aop.aspect;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect
{
    /*
     * Applicato dopo l'esecuzione dei metodi che iniziano con cl della classe 
     * ae.spring.aop.CashDesk
     */
    @AfterReturning(pointcut = "execution(public * ae.spring.aop.CashDesk.cl*(..))", returning = "returnValue")
    public void afterReturning(final JoinPoint jp, final Object returnValue) throws Throwable
    {
        // Log del risultato dell'invocazione del metodo
        System.out.println("After:\n\tRisultato: " + returnValue);
    }

    /*
     * Applicato ad ogni metodo del package ae.spring.aop.* in seguito al rilancio di un eccezione
     */
    @AfterThrowing("execution(public * ae.spring.aop.*.*(..))")
    public void afterThrowing(final JoinPoint jp) throws Throwable
    {
        System.out.println("afterThrowing:");
        System.err.println("\tErrore: " + jp.getSignature().getName());
    }

    @Around("execution(public * ae.spring.aop.CashDesk.refundProduct(..))")
    public Object aroundAdvice(final ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("Around:");
        // Log prima dell'invocazione del metodo
        System.out.println("\t\t[" + new Date() + "]\n\t\t" + pjp.getTarget().getClass() + "." + pjp.getSignature().getName()
                + "\n\t\tArgomenti: " + Arrays.toString(pjp.getArgs()));

        Object result = null;
        try
        {
            // Invocazione metodo
            result = pjp.proceed();
        }
        catch (final Exception ex)
        {
            System.err.println("\t\tErrore: " + pjp.getSignature().getName());
        }

        //Operazioni dopo l'esecuzione
        System.out.println("\t\tRisultato: " + result);
        return result;
    }

    /*
     * Applicato prima dell'esecuzione di tutti i metodi di tutte le classi
     */
    @Before("execution(* * .*(..))")
    public void beforeAdvice(final JoinPoint jp)
    {
        // Log prima dell'invocazione del metodo
        System.out.println("Before: [" + new Date() + "]\n\t" + jp.getTarget().getClass() + "." + jp.getSignature().getName()
                + "\n\tArgomenti: " + Arrays.toString(jp.getArgs()));
    }
}
