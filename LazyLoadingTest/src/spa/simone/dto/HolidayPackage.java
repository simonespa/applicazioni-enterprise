package spa.simone.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class HolidayPackage implements Serializable {

	private static final long serialVersionUID = 3484853544538843196L;
	private Long id;
	private String name;
	private String description;
	private TourOperator tourOperator;
	private Set<Service> services;

	public HolidayPackage() {
		services = new HashSet<Service>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tourOperatorId")
	@ForeignKey(name = "FK_HOLIDAYPACKAGE_TOUROPERATOR")
	public TourOperator getTourOperator() {
		return tourOperator;
	}

	public void setTourOperator(TourOperator tourOperator) {
		this.tourOperator = tourOperator;
	}

	@OneToMany(mappedBy = "holidayPackage")
	public Set<Service> getServices() {
		return services;
	}

	protected void setServices(Set<Service> services) {
		this.services = services;
	}

	public boolean addService(Service service) {
		service.setHolidayPackage(this);
		return this.services.add(service);
	}

	public boolean removeService(Service service) {
		service.setHolidayPackage(null);
		return this.services.remove(service);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tourOperator == null) ? 0 : tourOperator.hashCode());
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
		HolidayPackage other = (HolidayPackage) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tourOperator == null) {
			if (other.tourOperator != null)
				return false;
		} else if (!tourOperator.equals(other.tourOperator))
			return false;
		return true;
	}

}
