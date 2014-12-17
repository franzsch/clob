package de.hs.furtwangen.bam.spots.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.hs.furtwangen.bam.spots.model.User;
import de.hs.furtwangen.bam.spots.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	@Override
	public User addUser(User user)
	{
		return userRepository.save(user);
	}
	
	@Transactional(readOnly=true)
	@Override
	public User findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	@Transactional(readOnly=true)
	@Override
	public User findOne(int id){
		return userRepository.findOne(id);
	}
	
	@Transactional
	public void save(User user)
	{
		userRepository.save(user);
	}

}