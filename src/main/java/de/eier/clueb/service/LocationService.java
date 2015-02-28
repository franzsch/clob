package de.eier.clueb.service;

import de.eier.clueb.model.Location;

public interface LocationService {
	
	public Location createLocation(Location location);
	
	public void save(Location location);
	
	public Location findOne(Integer id);
	
	public Iterable<Location> findAll();

	public Location findLocationByZip(int zip);
	
}