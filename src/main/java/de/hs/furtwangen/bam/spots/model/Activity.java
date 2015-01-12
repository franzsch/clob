package de.hs.furtwangen.bam.spots.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Activity entity.
 *
 * @author Oliver Rövekamp
 */
@Entity
public class Activity extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -8602561360329162570L;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Rating rating;
	
	@ManyToOne
    @JoinColumn(name = "spot_spotId")
	@JsonBackReference
    private Spot spot;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	@Override
	public String toString() {
		return "Activity [name=" + name + ", rating=" + rating + "]";
	}
	
	

}
