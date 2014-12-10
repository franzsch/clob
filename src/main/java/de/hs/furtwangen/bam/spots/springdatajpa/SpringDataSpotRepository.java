package de.hs.furtwangen.bam.spots.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.hs.furtwangen.bam.spots.model.Spot;

public interface SpringDataSpotRepository extends CrudRepository<Spot, Long> {

}
