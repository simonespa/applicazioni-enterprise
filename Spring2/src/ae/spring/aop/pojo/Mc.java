package ae.spring.aop.pojo;

public class Mc extends Product
{
    private static final long serialVersionUID = 1L;

    @Override
    public ProductKind kind()
    {
        return ProductKind.MC;
    }
}
