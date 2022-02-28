package ae.spring.orm.musicstore.dto;

import java.io.Serializable;

public abstract class BasePojo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public abstract String toString();
}
