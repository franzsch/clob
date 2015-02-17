package de.eier.clueb.service;

import de.eier.clueb.model.User;

public interface UserService {
	
	public User addUser(User user);
	
	public User findByUsername(String username);
	
	public User findOne(int id);
	
	public void save(User user);
	
	public void delete(int id);

}
