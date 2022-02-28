package ae.spring.aop.pojo;

public enum ProductKind
{
    CD("cd"), MC("mc");

    private String value;

    private ProductKind(final String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
