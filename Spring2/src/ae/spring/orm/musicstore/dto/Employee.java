package ae.spring.orm.musicstore.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends BasePojo
{
    private static final long serialVersionUID = 1L;

    private Long employeeId;

    private String firstname;

    private String lastname;

    private Double salary;

    private Store store;

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
        final Employee other = (Employee) obj;
        if (employeeId == null)
        {
            if (other.employeeId != null)
            {
                return false;
            }
        }
        else if (!employeeId.equals(other.employeeId))
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
        if (salary == null)
        {
            if (other.salary != null)
            {
                return false;
            }
        }
        else if (!salary.equals(other.salary))
        {
            return false;
        }
        if (store == null)
        {
            if (other.store != null)
            {
                return false;
            }
        }
        else if (!store.equals(other.store))
        {
            return false;
        }
        return true;
    }

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getEmployeeId()
    {
        return employeeId;
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

    @Column(name = "salary")
    public Double getSalary()
    {
        return salary;
    }

    @ManyToOne()
    @JoinColumn(name = "store")
    public Store getStore()
    {
        return store;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (employeeId == null ? 0 : employeeId.hashCode());
        result = prime * result + (firstname == null ? 0 : firstname.hashCode());
        result = prime * result + (lastname == null ? 0 : lastname.hashCode());
        result = prime * result + (salary == null ? 0 : salary.hashCode());
        result = prime * result + (store == null ? 0 : store.hashCode());
        return result;
    }

    public void setEmployeeId(final Long employeeId)
    {
        this.employeeId = employeeId;
    }

    public void setFirstname(final String firstname)
    {
        this.firstname = firstname;
    }

    public void setLastname(final String lastname)
    {
        this.lastname = lastname;
    }

    public void setSalary(final Double salary)
    {
        this.salary = salary;
    }

    public void setStore(final Store store)
    {
        this.store = store;
    }

    @Override
    public String toString()
    {
        return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname + ", salary="
                + salary + ", store=" + store.getName() + "]";
    }
}
