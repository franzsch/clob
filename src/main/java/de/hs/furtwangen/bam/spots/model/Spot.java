package de.hs.furtwangen.bam.spots.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Spot entity.
 *
 * @author Oliver Rövekamp
 */
@Entity
public class Spot extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -8602561360329162570L;

	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private Location location;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_userId")
	private User user;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spot")
	private Set<Activity> activities = new HashSet<Activity>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "spot")
	private Set<Advertisement> advertisements = new HashSet<Advertisement>();

	public Spot() {
		this.location = new Location();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Set<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(Set<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	@Override
	public String toString() {
		return "Spot [name=" + name + ", location=" + location
				+ ", activities=" + activities + "]";
	}

}
