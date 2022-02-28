package ae.spring.orm.musicstore.dto;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MusicCard")
public class MusicCard extends BasePojo
{
    private static final long serialVersionUID = 1L;

    private String code;

    private Customer customer;

    private Long musicCardId;

    private Set<String> promotions;

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final MusicCard other = (MusicCard) obj;
        if (code == null)
        {
            if (other.code != null)
            {
                return false;
            }
        }
        else if (!code.equals(other.code))
        {
            return false;
        }
        if (customer == null)
        {
            if (other.customer != null)
            {
                return false;
            }
        }
        else if (!customer.equals(other.customer))
        {
            return false;
        }
        if (musicCardId == null)
        {
            if (other.musicCardId != null)
            {
                return false;
            }
        }
        else if (!musicCardId.equals(other.musicCardId))
        {
            return false;
        }
        return true;
    }

    @Column(name = "code", length = 128, unique = true)
    public String getCode()
    {
        return code;
    }

    @OneToOne(targetEntity = Customer.class, mappedBy = "musicCard")
    public Customer getCustomer()
    {
        return customer;
    }

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getMusicCardId()
    {
        return musicCardId;
    }

    @ElementCollection
    @CollectionTable(name = "Promotions", joinColumns = @JoinColumn(name = "idMusicCard"))
    public Set<String> getPromotions()
    {
        return promotions;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (code == null ? 0 : code.hashCode());
        result = prime * result + (customer == null ? 0 : customer.hashCode());
        result = prime * result + (musicCardId == null ? 0 : musicCardId.hashCode());
        return result;
    }

    public void setCode(final String code)
    {
        this.code = code;
    }

    public void setCustomer(final Customer customer)
    {
        this.customer = customer;
    }

    public void setMusicCardId(final Long musicCardId)
    {
        this.musicCardId = musicCardId;
    }

    public void setPromotions(final Set<String> promotions)
    {
        this.promotions = promotions;
    }

    @Override
    public String toString()
    {
        return "MusicCard [code=" + code + ", customer=" + customer + ", musicCardId=" + musicCardId + "]";
    }

}
