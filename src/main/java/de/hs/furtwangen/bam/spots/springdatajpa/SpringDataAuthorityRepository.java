package de.hs.furtwangen.bam.spots.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.hs.furtwangen.bam.spots.model.Authority;

public interface SpringDataAuthorityRepository extends CrudRepository<Authority, Long> {

}
