package de.eier.clueb.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.Location;

public interface SpringDataLocationRepository extends CrudRepository<Location, Long> {

}
