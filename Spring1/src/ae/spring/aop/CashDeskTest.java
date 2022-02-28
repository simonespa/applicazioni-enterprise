package ae.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ae.spring.aop.pojo.Cd;
import ae.spring.aop.pojo.Mc;
import ae.spring.aop.pojo.Product;

public final class CashDeskTest
{
    public static void main(final String[] args) throws CashDeskNotOpenException
    {
        final ApplicationContext context = new ClassPathXmlApplicationContext("ae/spring/aop/spring-beans2.xml");

        final CashDesk cashDesk = context.getBean("cashDeskProxy", CashDesk.class);
        final Cd cd2 = createCd("author_1", null, 20.3, "title_2");

        cashDesk.open();
        cashDesk.sellProduct(createCd("author_1", null, 20.3, "title_1"));
        cashDesk.sellProduct(cd2);
        cashDesk.sellProduct(createCd("author_2", null, 20.3, "title_3"));
        cashDesk.refundProduct(cd2);
        cashDesk.close();

        cashDesk.close();
    }

    static Cd createCd(final String author, final byte[] cover, final Double price, final String title)
    {
        return (Cd) createProduct(Cd.class, author, cover, price, title);
    }

    static Mc createMc(final String author, final byte[] cover, final Double price, final String title)
    {
        return (Mc) createProduct(Mc.class, author, cover, price, title);
    }

    static Product createProduct(final Class<? extends Product> clazz, final String author, final byte[] cover,
            final Double price, final String title)
    {
        try
        {
            final Product product = clazz.newInstance();
            product.setAuthor(author);
            product.setCover(cover);
            product.setPrice(price);
            product.setTitle(title);
            return product;
        }
        catch (final InstantiationException e)
        {
            throw new RuntimeException(e);
        }
        catch (final IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }
    }
}
