package de.hs.furtwangen.bam.spots.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.hs.furtwangen.bam.spots.model.Rating;

public interface SpringDataRatingRepository extends CrudRepository<Rating, Long> {

}
