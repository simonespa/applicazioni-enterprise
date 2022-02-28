package spa.simone.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class Service implements Serializable {

	private static final long serialVersionUID = 6227757108429729162L;
	private Long id;
	private String name;
	private Double price;
	private HolidayPackage holidayPackage;

	public Service() {
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "holidayPackageId")
	@ForeignKey(name = "FK_SERVICE_HOLIDAYPACKAGE")
	public HolidayPackage getHolidayPackage() {
		return holidayPackage;
	}

	public void setHolidayPackage(HolidayPackage holidayPackage) {
		holidayPackage.addService(this);
		this.holidayPackage = holidayPackage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((holidayPackage == null) ? 0 : holidayPackage.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (holidayPackage == null) {
			if (other.holidayPackage != null)
				return false;
		} else if (!holidayPackage.equals(other.holidayPackage))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

}
