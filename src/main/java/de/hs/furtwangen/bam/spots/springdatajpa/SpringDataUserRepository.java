package de.hs.furtwangen.bam.spots.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.hs.furtwangen.bam.spots.model.User;

public interface SpringDataUserRepository extends CrudRepository<User, Long> {

}
