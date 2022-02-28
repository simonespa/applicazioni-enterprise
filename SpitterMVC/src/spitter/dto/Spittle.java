package spitter.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Spittle implements Serializable {

	private static final long serialVersionUID = 8683418416675147233L;
	private Long id;
	private String message;
	private Spitter spitter;

	public Spittle() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@Column(nullable = false)
	public String getMessage() {
		return message;
	}

	@ManyToOne
	@JoinColumn(name = "id_spitter", nullable = false)
	@ForeignKey(name = "FK_SPITTLE_SPITTER")
	public Spitter getSpitter() {
		return spitter;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSpitter(Spitter spitter) {
		this.spitter = spitter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((spitter == null) ? 0 : spitter.hashCode());
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
		Spittle other = (Spittle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (spitter == null) {
			if (other.spitter != null)
				return false;
		} else if (!spitter.equals(other.spitter))
			return false;
		return true;
	}

}
