package de.hs.furtwangen.bam.spots.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "users")
public class User extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;

	@Column(unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "residence")
	private String residence;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "zipCode")
	private String zipCode;
	
	@Column(name = "phone")
	private String phone;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private List<Authority> authoritiesList = new ArrayList<Authority>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Spot> spots = new HashSet<Spot>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Advertisement advertisement;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Authority> getAuthoritiesList() {
		return authoritiesList;
	}
	
	public void add(Authority authority){
		authoritiesList.add(authority);
	}

	public void setAuthoritiesList(List<Authority> authoritiesList) {
		this.authoritiesList = authoritiesList;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password
				+ ", email=" + email
				+ ", gender=" + gender + ", residence=" + residence
				+ ", street=" + street + ", zipCode=" + zipCode + ", phone="
				+ phone + ", authoritiesList=" + authoritiesList + "]";
	}

	public Set<Spot> getSpots() {
		return spots;
	}

	public void setSpots(Set<Spot> spots) {
		this.spots = spots;
	}
	
	public void add(Spot spot){
		spots.add(spot);
	}

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}
	
}
