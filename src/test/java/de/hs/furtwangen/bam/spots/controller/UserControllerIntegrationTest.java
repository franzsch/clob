package de.hs.furtwangen.bam.spots.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import de.hs.furtwangen.bam.spots.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:/spring/business-config.xml")
public class UserControllerIntegrationTest {

	@Autowired
	private WebApplicationContext wac;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	private MockMvc mockMvc;

	@Autowired
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
				.addFilters(this.springSecurityFilterChain).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddUser() throws Exception {

		String jsonUser = "{\"email\":\"chhenle@web.de\",\"username\":\"chhenle@web.de\",\"password\":\"1\",\"password1\":\"1\",\"firstname\":\"1\",\"lastname\":\"1\"}";

		System.out.println("jsonUser " + jsonUser);

		mockMvc.perform(
				post("/user/addUser").contentType(MediaType.APPLICATION_JSON)
						.content(jsonUser).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		// .andDo(MockMvcResultHandlers.print());

	}

	@Test
	public void authenticateCorrect() throws Exception {
		String json = "{\"username\":\"henlechr\",\"password\":\"henlechr\"}";

		mockMvc.perform(
				post("/user/authenticate")
						.contentType(MediaType.APPLICATION_JSON).content(json)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(
						MockMvcResultMatchers.content().string(
								Matchers.containsString("token")));
		// .andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void authenticateUserNameUnknown() throws Exception {
		String json = "{\"username\":\"hesfasd\",\"password\":\"henlechr\"}";

		mockMvc.perform(
				post("/user/authenticate")
						.contentType(MediaType.APPLICATION_JSON).content(json)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(
						MockMvcResultMatchers.content().string(
								Matchers.isEmptyString()));
		// .andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void authenticatePasswordWrong() throws Exception {
		String json = "{\"username\":\"henlechr\",\"password\":\"asfsaf\"}";

		mockMvc.perform(
				post("/user/authenticate")
						.contentType(MediaType.APPLICATION_JSON).content(json)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(
						MockMvcResultMatchers.content().string(
								Matchers.isEmptyString()));
		// .andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void getUsernameAnonym() throws Exception {
		mockMvc.perform(
				get("/user/username").contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().is4xxClientError())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void getUsernameTestUser() throws Exception {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("X-Auth-Token",
				"henlechr:1423915101140:7877ecee7059423b3ac3ca29f374d0a0");

		mockMvc.perform(
				get("/user/username").headers(httpHeaders)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(
						MockMvcResultMatchers.content().string(
								Matchers.containsString("henlechr")))
				.andDo(MockMvcResultHandlers.print());
	}

}
