package ae.spring.orm.musicstore.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Cd")
public class Cd extends Product
{
    private static final long serialVersionUID = 1L;

    @Override
    public ProductKind kind()
    {
        return ProductKind.CD;
    }

}
