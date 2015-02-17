package de.eier.clueb.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.Activity;

public interface SpringDataActivityRepository extends CrudRepository<Activity, Long> {

}
