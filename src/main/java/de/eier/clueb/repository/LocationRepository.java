package de.eier.clueb.repository;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

	public Location findByZip(int zip);
	
	public Location findByOrt(String ort);
	
}
