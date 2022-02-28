package ae.spring.orm.musicstore.dto;

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
