package de.eier.clueb.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.Spot;

public interface SpringDataSpotRepository extends CrudRepository<Spot, Long> {

}
