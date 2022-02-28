package ae.spring.bean.three;

import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3
{
    public static void main(final String[] args)
    {
        final ApplicationContext context = new ClassPathXmlApplicationContext("ae/spring/bean/three/bean-config.xml");

        final Complicated complicated = context.getBean("complicatedObject", Complicated.class);

        System.out.println("list:");
        for (final String string : complicated.getList())
        {
            System.out.println("\t" + string);
        }

        System.out.println("\nset:");
        for (final MyObject mo : complicated.getSet())
        {
            System.out.println("\t" + mo);
        }

        System.out.println("\nmap:");
        final Set<Entry<String, Double>> entrySet = complicated.getMap().entrySet();
        for (final Entry<String, Double> entry : entrySet)
        {
            System.out.println("\t" + entry.getKey() + "->" + entry.getValue());
        }

        System.out.println("\n");
        final MyObject myObject = context.getBean("myObjectByProperties", MyObject.class);
        System.out.println(myObject);
    }
}
