package de.eier.clueb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Location entity.
 * 
 * @author Oliver Rövekamp
 */
@Entity
public class Location extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "town")
	private String town;
	
	@Column(name = "type")
	private String type;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Spot spot;
	
	public Location() {
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setEvent(Spot spot) {
		this.spot = spot;
	}

	public Spot getSpot() {
		return this.spot;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", country=" + country + ", street="
				+ street + ", town=" + town + ", type=" + type + "]";
	}
	
	

}
