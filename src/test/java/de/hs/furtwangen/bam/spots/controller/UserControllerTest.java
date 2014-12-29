package de.hs.furtwangen.bam.spots.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.hs.furtwangen.bam.spots.model.User;
import de.hs.furtwangen.bam.spots.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Mock
	private UserService userService;
	
	@Mock
	private PasswordEncoder passwordEncoder;

	@Before
	public void setUp() throws Exception {
		 mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService, passwordEncoder))
	                .build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddUser() throws Exception {
		User user = new User();
		user.setId(1);
		user.setFirstname("Christian");
		user.setLastname("Henle");
		user.setPassword("12345");
		user.setUsername("chenle");
		user.setEmail("chhenle@test.de");

		ObjectMapper mapper = new ObjectMapper();
		String jsonUser = mapper.writeValueAsString(user);
		System.out.println("jsonUser " + jsonUser);
		
		Mockito.when(userService.addUser(any(User.class))).thenReturn(user);

		mockMvc.perform(
				post("/user/addUser").contentType(MediaType.APPLICATION_JSON)
						.content(jsonUser).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
				//.andDo(MockMvcResultHandlers.print());
		
		verify(userService, times(1)).addUser(any(User.class));
        verifyZeroInteractions(userService);

	}
	
	@Test
	public void authenticate() throws Exception {
		User user = new User();
		user.setUsername("henlechr");
		user.setPassword("henlechr");
		
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonUser = mapper.writeValueAsString(user);
		System.out.println("jsonUser " + jsonUser);
		
		Mockito.when(userService.findByUsername("henlechr")).thenReturn(user);
		
		Mockito.when(passwordEncoder.matches("henlechr", "henlechr")).thenReturn(true);

		mockMvc.perform(
				post("/user/authenticate").contentType(MediaType.APPLICATION_JSON)
						.content(jsonUser).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("token")))
				.andDo(MockMvcResultHandlers.print());
		
		verify(userService, times(1)).findByUsername("henlechr");
        verifyZeroInteractions(userService);

	}

}
