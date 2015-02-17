package de.eier.clueb.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.Rating;

public interface SpringDataRatingRepository extends CrudRepository<Rating, Long> {

}
