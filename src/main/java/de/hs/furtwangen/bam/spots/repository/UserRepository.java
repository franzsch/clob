package de.hs.furtwangen.bam.spots.repository;

import org.springframework.data.repository.CrudRepository;

import de.hs.furtwangen.bam.spots.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
