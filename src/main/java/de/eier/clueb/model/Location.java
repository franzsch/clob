package de.eier.clueb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "location")
public class Location extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "zip")
	private int	zip;
	
	@Column(name = "ort")
	private String ort;
	
	@Column(name = "kreis")
	private String kreis;
	
	@Column(name = "bundesland")
	private String bundesland;

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getKreis() {
		return kreis;
	}

	public void setKreis(String kreis) {
		this.kreis = kreis;
	}

	public String getBundesland() {
		return bundesland;
	}

	public void setBundesland(String bundesland) {
		this.bundesland = bundesland;
	}
	
}
