package de.eier.clueb.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.Advertisement;

public interface SpringDataAdvertisementRepository extends CrudRepository<Advertisement, Long> {

}
