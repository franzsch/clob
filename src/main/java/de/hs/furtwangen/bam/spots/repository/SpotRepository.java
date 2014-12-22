package de.hs.furtwangen.bam.spots.repository;

import org.springframework.data.repository.CrudRepository;

import de.hs.furtwangen.bam.spots.model.Spot;

public interface SpotRepository extends CrudRepository<Spot, Long>{

	public Spot findByName(String name);
	
}
