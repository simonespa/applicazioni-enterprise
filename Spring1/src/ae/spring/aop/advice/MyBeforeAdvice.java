package ae.spring.aop.advice;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice
{
    @Override
    public void before(final Method method, final Object[] args, final Object target) throws Throwable
    {
        System.out.println("[" + new Date() + "]\n\t" + target.getClass() + "." + method.getName() + "\n\tArgomenti: "
                + Arrays.toString(args));
    }
}
