package ae.spring.aop;

import java.util.ArrayList;
import java.util.List;

import ae.spring.aop.pojo.Product;

public class CashDeskImpl implements CashDesk
{
    private List<Product> products;

    @Override
    public double close() throws CashDeskNotOpenException
    {
        isOpen();
        double cash = 0d;
        for (final Product product : products)
        {
            cash += product.getPrice();
        }
        products = null;
        return cash;
    }

    @Override
    public void open()
    {
        products = new ArrayList<Product>();
    }

    @Override
    public void refundProduct(final Product product) throws CashDeskNotOpenException
    {
        isOpen();
        products.remove(product);
    }

    @Override
    public void sellProduct(final Product product) throws CashDeskNotOpenException
    {
        isOpen();
        products.add(product);
    }

    private void isOpen() throws CashDeskNotOpenException
    {
        if (products == null)
        {
            throw new CashDeskNotOpenException();
        }
    }
}
