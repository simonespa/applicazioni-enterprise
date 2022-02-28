/*
 * This file is part of HibernateTest.
 * 
 * <brief description of the project>
 * Copyright (C) 2012 Simone Spaccarotella {spa.simone@gmail.com}
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package hibernate.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author Simone Spaccarotella {spa.simone@gmail.com}
 * 
 */
@Entity
public class City {

	private Long id;
	private String name;
	private Set<House> houses;
	private Set<CityTag> cityTags;

	public City() {
		houses = new HashSet<House>();
		cityTags = new HashSet<CityTag>();
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@OneToMany(mappedBy = "city")
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	public Set<House> getHouses() {
		return houses;
	}

	@ManyToMany
	@JoinTable(name = "CityClassification", joinColumns = @JoinColumn(name = "cityId"), inverseJoinColumns = @JoinColumn(name = "cityTagId"))
	public Set<CityTag> getCityTags() {
		return cityTags;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	protected void setHouses(Set<House> houses) {
		this.houses = houses;
	}

	/**
	 * Se una casa H si trova in una città C1, la città C1 avrà un riferimento
	 * alla casa H. Nel momento in cui la casa H viene aggiunta da un'altra città
	 * C2, dobbiamo garantire la non ubiquità della casa. Per fare ciò, bisogna
	 * eliminare il riferimento (C1 --> H) e settare il nuovo riferimento (C2 -->
	 * H). Il riferimento (H --> C1) invece, verrà sovrascritto con il nuovo (H
	 * --> C2).
	 */
	public boolean addHouse(House house) {
		/*
		 * City c = house.getCity(); if (c != null) { if (c != this) {
		 * c.removeHouse(house); } else { return false; } }
		 */
		house.setCity(this);
		return this.houses.add(house);
	}

	public boolean removeHouse(House house) {
		house.setCity(null);
		return this.houses.remove(house);
	}

	protected void setCityTags(Set<CityTag> cityTags) {
		this.cityTags = cityTags;
	}

	public boolean addCityTag(CityTag cityTag) {
		cityTag.addCity(this);
		return this.cityTags.add(cityTag);
	}

	public boolean removeCityTag(CityTag cityTag) {
		cityTag.removeCity(this);
		return this.cityTags.remove(cityTag);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityTags == null) ? 0 : cityTags.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		City other = (City) obj;
		if (cityTags == null) {
			if (other.cityTags != null)
				return false;
		} else if (!cityTags.equals(other.cityTags))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}