package de.eier.clueb.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Advertisement entity.
 *
 * @author Oliver Rövekamp
 */
@Entity
public class Advertisement extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -8602561360329162570L;

	@Column(name = "name")
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "spot_spotId")
	@JsonIgnore
    private Spot spot;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}