package ae.spring.aop.pojo;

public class Cd extends Product
{
    private static final long serialVersionUID = 1L;

    @Override
    public ProductKind kind()
    {
        return ProductKind.CD;
    }
}
