package ae.spring.aop;

import ae.spring.aop.pojo.Product;

public interface CashDesk
{
    double close() throws CashDeskNotOpenException;

    double getPartialCash() throws CashDeskNotOpenException;

    void open();

    void refundProduct(Product product) throws CashDeskNotOpenException;

    void sellProduct(Product product) throws CashDeskNotOpenException;
}
