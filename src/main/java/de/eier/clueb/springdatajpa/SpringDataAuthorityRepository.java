package de.eier.clueb.springdatajpa;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.Authority;

public interface SpringDataAuthorityRepository extends CrudRepository<Authority, Long> {

}
