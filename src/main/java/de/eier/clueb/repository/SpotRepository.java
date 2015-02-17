package de.eier.clueb.repository;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.Spot;

public interface SpotRepository extends CrudRepository<Spot, Integer>{

	public Spot findByName(String name);
	
}
