package de.hs.furtwangen.bam.spots.repository;

import org.springframework.data.repository.CrudRepository;

import de.hs.furtwangen.bam.spots.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {
	
	public Iterable<Activity> findBySpotId(Integer id);

}
