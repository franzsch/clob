package de.hs.furtwangen.bam.spots.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.hs.furtwangen.bam.spots.model.User;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@RequestMapping(value = "/addTestUser", method = RequestMethod.POST)
	public void addTestUser(@RequestBody String testUser) {
		System.out.println("testUser " + testUser);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addTestUser(@RequestBody User user) {
		System.out.println("user " + user);
	}
	
	@RequestMapping(value = "/user.json", method = RequestMethod.GET)
	public User addTestUser() {
		User user = new User();
		user.setId(1);
		user.setFirstname("firstName");
		user.setLastname("lastName");
		user.setPassword("password");
		user.setUsername("username");
		return user;
	}
}
