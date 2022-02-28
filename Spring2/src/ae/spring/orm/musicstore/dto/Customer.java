package ae.spring.orm.musicstore.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer extends BasePojo
{

    private static final long serialVersionUID = 1L;

    private String address;

    private Long customerId;

    private String email;

    private String firstname;

    private String lastname;

    private MusicCard musicCard;

    private final List<Sale> sales = new ArrayList<Sale>();

    private String telephone;

    public void addSale(final Sale sale)
    {
        sales.add(sale);
    }

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
        final Customer other = (Customer) obj;
        if (address == null)
        {
            if (other.address != null)
            {
                return false;
            }
        }
        else if (!address.equals(other.address))
        {
            return false;
        }
        if (customerId == null)
        {
            if (other.customerId != null)
            {
                return false;
            }
        }
        else if (!customerId.equals(other.customerId))
        {
            return false;
        }
        if (email == null)
        {
            if (other.email != null)
            {
                return false;
            }
        }
        else if (!email.equals(other.email))
        {
            return false;
        }
        if (lastname == null)
        {
            if (other.lastname != null)
            {
                return false;
            }
        }
        else if (!lastname.equals(other.lastname))
        {
            return false;
        }
        if (musicCard == null)
        {
            if (other.musicCard != null)
            {
                return false;
            }
        }
        else if (!musicCard.equals(other.musicCard))
        {
            return false;
        }
        if (firstname == null)
        {
            if (other.firstname != null)
            {
                return false;
            }
        }
        else if (!firstname.equals(other.firstname))
        {
            return false;
        }
        if (sales == null)
        {
            if (other.sales != null)
            {
                return false;
            }
        }
        else if (!sales.equals(other.sales))
        {
            return false;
        }
        if (telephone == null)
        {
            if (other.telephone != null)
            {
                return false;
            }
        }
        else if (!telephone.equals(other.telephone))
        {
            return false;
        }
        return true;
    }

    @Column(name = "address", length = 128)
    public String getAddress()
    {
        return address;
    }

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getCustomerId()
    {
        return customerId;
    }

    @Column(name = "email", length = 128)
    public String getEmail()
    {
        return email;
    }

    @Column(name = "firstname", length = 128, nullable = false)
    public String getFirstname()
    {
        return firstname;
    }

    @Column(name = "lastname", length = 128, nullable = false)
    public String getLastname()
    {
        return lastname;
    }

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idMusicCard")
    public MusicCard getMusicCard()
    {
        return musicCard;
    }

    @OneToMany(targetEntity = Sale.class, mappedBy = "customer")
    public List<Sale> getSales()
    {
        return sales;
    }

    @Column(name = "telephone", length = 128)
    public String getTelephone()
    {
        return telephone;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (address == null ? 0 : address.hashCode());
        result = prime * result + (customerId == null ? 0 : customerId.hashCode());
        result = prime * result + (email == null ? 0 : email.hashCode());
        result = prime * result + (lastname == null ? 0 : lastname.hashCode());
        result = prime * result + (musicCard == null ? 0 : musicCard.hashCode());
        result = prime * result + (firstname == null ? 0 : firstname.hashCode());
        result = prime * result + (sales == null ? 0 : sales.hashCode());
        result = prime * result + (telephone == null ? 0 : telephone.hashCode());
        return result;
    }

    public void setAddress(final String address)
    {
        this.address = address;
    }

    public void setCustomerId(final Long customerId)
    {
        this.customerId = customerId;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public void setFirstname(final String firstname)
    {
        this.firstname = firstname;
    }

    public void setLastname(final String lastname)
    {
        this.lastname = lastname;
    }

    public void setMusicCard(final MusicCard musicCard)
    {
        this.musicCard = musicCard;
    }

    public void setSales(final List<Sale> sales)
    {
        this.sales.clear();
        this.sales.addAll(sales);
    }

    public void setTelephone(final String telephone)
    {
        this.telephone = telephone;
    }

    @Override
    public String toString()
    {
        return "Customer [address=" + address + ", customerId=" + customerId + ", email=" + email + ", lastname=" + lastname
                + ", musicCard=" + musicCard + ", name=" + firstname + ", telephone=" + telephone + "]";
    }

}
