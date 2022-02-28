package spitter.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Spitter implements Serializable {

	private static final long serialVersionUID = 6783744924581076698L;
	private Long id;
	private String firstName;
	private String lastName;
	private Set<Spittle> spittles;

	public Spitter() {
		spittles = new HashSet<Spittle>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(name = "first_name", nullable = false, unique = true)
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	@OneToMany(mappedBy = "spitter")
	public Set<Spittle> getSpittles() {
		return spittles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected void setSpittles(Set<Spittle> spittles) {
		this.spittles = spittles;
	}

	public boolean addSpittle(Spittle spittle) {
		spittle.setSpitter(this);
		return spittles.add(spittle);
	}

	public boolean removeSpittle(Spittle spittle) {
		spittle.setSpitter(null);
		return spittles.remove(spittle);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Spitter other = (Spitter) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
