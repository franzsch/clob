package de.eier.clueb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.eier.clueb.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		de.eier.clueb.model.User user = userRepository.findByUsername(username);
		
		if(user == null)
		{
			throw new UsernameNotFoundException(username);
		}
						
		return user;
	}
}