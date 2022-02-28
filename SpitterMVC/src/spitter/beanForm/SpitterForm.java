package spitter.beanForm;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SpitterForm implements Serializable {

	private static final long serialVersionUID = -7827472578810285362L;
	@NotNull(message="Il campo è obbligatorio")
	@Size(min=3, max=20, message="Il nome dev'essere una stringa compresa tra i 3 e i 20 caratteri")
	private String firstName;
	@NotNull(message="Il campo è obbligatorio")
	@Size(min=3, max=20, message="Il cognome dev'essere una stringa compresa tra i 3 e i 20 caratteri")
	private String lastName;

	public SpitterForm() {
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
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
		SpitterForm other = (SpitterForm) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
