package ae.spring.orm.musicstore.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Mc")
public class Mc extends Product
{
    private static final long serialVersionUID = 1L;

    @Override
    public ProductKind kind()
    {
        return ProductKind.MC;
    }

}
