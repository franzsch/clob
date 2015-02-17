package de.eier.clueb.repository;

import org.springframework.data.repository.CrudRepository;

import de.eier.clueb.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByUsername(String username);
	
}
