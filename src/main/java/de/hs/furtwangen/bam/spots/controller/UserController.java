package de.hs.furtwangen.bam.spots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import de.hs.furtwangen.bam.spots.model.Spot;
import de.hs.furtwangen.bam.spots.model.User;
import de.hs.furtwangen.bam.spots.service.SpotService;
import de.hs.furtwangen.bam.spots.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private final UserService userService;
	
	@Autowired
	private final SpotService spotService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserController(UserService userService, SpotService spotService, 
			PasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.spotService = spotService;
		this.passwordEncoder = passwordEncoder;
	}

	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;

	/**
	 * Recieves Username und Password as JSON. Returns AuthenticationToken if
	 * Username and Password is correct.
	 * 
	 * Returns nothing if Username and Password are wrong.
	 * 
	 * @param userAuth
	 * @return
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public TokenTransfer authenticate(@RequestBody UserAuth userAuth) {
		
		System.out.println(userAuth.getUsername()+" "+passwordEncoder.encode(userAuth.getPassword()));

		UserDetails userDetails = this.userService.findByUsername(userAuth
				.getUsername());

		if (userDetails == null) {
			return null;
		} else {
			if (passwordEncoder.matches(userAuth.getPassword(),
					userDetails.getPassword())) {
				return new TokenTransfer(TokenUtils.createToken(userDetails));
			}
		}

		return null;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody User user) {
		System.out.println("user " + user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.addUser(user);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getUser() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		if (authentication.getPrincipal() instanceof User) {
			User user = (User) authentication.getPrincipal();
			user.setSpots(null);

			return user;
		}

		return null;
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void editUser(@RequestBody User user) {
		System.out.println("user to be changed: " + user);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.save(user);
	}

	/**
	 * 
	 * @return Username from AuthenticatonToken
	 */
	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public UserTransfer getUsername() {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		if (authentication.getPrincipal() instanceof User) {
			User user = (User) authentication.getPrincipal();

			return new UserTransfer(user.getUsername());
		}

		if (authentication.getPrincipal() instanceof String) {
			String user = (String) authentication.getPrincipal();

			return new UserTransfer(user);
		}
		return new UserTransfer("no User found");
	}

	@RequestMapping(value = "/createSpot", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void createSpot(@RequestBody Spot spot) {
		System.out.println("spot to be added: " + spot);
		spotService.createSpot(spot);
	}
	
	@RequestMapping(value = "/editSpot", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void editSpot(@RequestBody Spot spot) {
		System.out.println("spot to be changed: " + spot);
		
		spotService.save(spot);
	}
	
}
