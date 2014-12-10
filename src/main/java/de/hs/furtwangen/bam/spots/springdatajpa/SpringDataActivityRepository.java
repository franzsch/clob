package de.hs.furtwangen.bam.spots.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.hs.furtwangen.bam.spots.model.Activity;

public interface SpringDataActivityRepository extends CrudRepository<Activity, Long> {

}
