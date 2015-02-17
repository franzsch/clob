package de.eier.clueb.repository;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {
	
	public Iterable<Activity> findBySpotId(Integer id);

}
