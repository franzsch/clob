package de.hs.furtwangen.bam.spots.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.hs.furtwangen.bam.spots.model.Advertisement;

public interface SpringDataAdvertisementRepository extends CrudRepository<Advertisement, Long> {

}
