package de.eier.clueb.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.User;

public interface SpringDataUserRepository extends CrudRepository<User, Long> {

}
