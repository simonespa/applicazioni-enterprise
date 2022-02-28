package ae.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectWithPointCut
{
    @Before("pcMetodiGet()")
    public void getterCalled(final JoinPoint jp)
    {
        System.out.println("Method " + jp.getSignature().getName() + " is a getter");
    }

    @After("pcMetodiGet() and pcMetodiCheRestituisconoUnDouble()")
    public void getterCalledThatReturnsDouble(final JoinPoint jp)
    {
        System.out
                .println("ANDing of pointcuts: Method " + jp.getSignature().getName() + " is a getter that also returns double");
    }

    @After("pcMetodiGet() or pcMetodiVoid()")
    public void getterOrVoidMethodCalled(final JoinPoint jp)
    {
        System.out.println("ORing of pointcuts: Method " + jp.getSignature().getName() + " is a getter OR is void");
    }

    @After("pcMetodiCheRestituisconoUnDouble()")
    public void metodiCheRestituisconoUnDouble(final JoinPoint jp)
    {
        System.out.println("Method " + jp.getSignature().getName() + " returned int");
    }

    @Pointcut("execution(public * *())")
    public void pcMetodiCheNonPrendonoArgomenti()
    {
    }

    @Pointcut("execution(public double *())")
    public void pcMetodiCheRestituisconoUnDouble()
    {
    }

    @Pointcut("execution(public !void get*())")
    public void pcMetodiGet()
    {
    }

    @Pointcut("execution(public void *(..))")
    public void pcMetodiVoid()
    {
    }
}
