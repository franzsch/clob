package de.hs.furtwangen.bam.spots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.hs.furtwangen.bam.spots.model.User;
import de.hs.furtwangen.bam.spots.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody User user) {
		System.out.println("user " + user);
	}
	
	@RequestMapping(value = "/user.json", method = RequestMethod.GET)
	public User getUser() {
		User user = new User();
		user.setId(1);
		user.setFirstname("firstName");
		user.setLastname("lastName");
		user.setPassword("password");
		user.setUsername("username");
		return user;
	}
}
