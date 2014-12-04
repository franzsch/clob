package de.hs.furtwangen.bam.spots.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.hs.furtwangen.bam.spots.model.User;
import de.hs.furtwangen.bam.spots.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/spring/business-config.xml")
public class UserControllerIntegrationTest {


		@Autowired
		private WebApplicationContext wac;

		private MockMvc mockMvc;

		@Autowired
		private UserService userService;

		@Before
		public void setUp() throws Exception {
			this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
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

			//ObjectMapper mapper = new ObjectMapper();
			//String jsonUser = mapper.writeValueAsString(user);
			
			String jsonUser = "{\"email\":\"chhenle@web.de\",\"username\":\"chhenle@web.de\",\"password\":\"1\",\"password1\":\"1\",\"firstname\":\"1\",\"lastname\":\"1\"}";

			
			System.out.println("jsonUser " + jsonUser);
			
			mockMvc.perform(
					post("/user/addUser").contentType(MediaType.APPLICATION_JSON)
							.content(jsonUser).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated());
					//.andDo(MockMvcResultHandlers.print());

		}

	}

