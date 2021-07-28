package com.gutotech.fatecandoapi.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gutotech.fatecandoapi.model.UserDTO;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.UserService;

/**
 * Test class for {@link UserRestController}
 *
 * @author Gustavo Alves
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
@FixMethodOrder(MethodSorters.DEFAULT)
public class UserRestControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UserService userService;

	@Test
	public void testCreateUserSuccess() throws Exception {
		UserDTO user = new UserDTO();
		user.setFullName("Gustavo");
		user.setEmail("gustavo@fatecando.com");
		user.setPassword("1234");

		ObjectMapper mapper = new ObjectMapper();
		String newUserAsJSON = mapper.writeValueAsString(user);

		mockMvc.perform(post("/api/users").content(newUserAsJSON)
					.accept(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("fullName").value(user.getFullName()))
				.andExpect(jsonPath("email").value(user.getEmail()));
		
		assertThat(userService.findByEmail(user.getEmail())).isNotNull();
	}
	
	@WithMockUser(authorities = Roles.STUDENT)
	@Test
	public void testGetUserError() throws Exception {
		mockMvc.perform(get("/api/users/{id}", -1))
				.andExpect(status().isNotFound());
	}
	
	@WithMockUser(authorities = Roles.STUDENT)
	@Test
	public void testUpdateUserSuccess() throws Exception {
		UserDTO dto = new UserDTO(userService.findById(1L));
		
		dto.setFullName("New Name");

		ObjectMapper mapper = new ObjectMapper();
		String newUserAsJSON = mapper.writeValueAsString(dto);

		mockMvc.perform(put("/api/users/{id}", dto.getId()).content(newUserAsJSON)
					.accept(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("fullName").value(dto.getFullName()))
				.andExpect(jsonPath("email").value(dto.getEmail()));

		mockMvc.perform(get("/api/users/{id}", dto.getId())
					.accept(MediaType.APPLICATION_JSON)
					.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("fullName").value(dto.getFullName()))
				.andExpect(jsonPath("email").value(dto.getEmail()));
	}
	
	@WithMockUser(authorities = Roles.STUDENT)
	@Test
	public void testUpdateUserError() throws Exception {
		UserDTO dto = new UserDTO(userService.findById(1L));
		
		dto.setFullName("");

		ObjectMapper mapper = new ObjectMapper();
		String newUserAsJSON = mapper.writeValueAsString(dto);

		mockMvc.perform(put("/api/users/{id}", dto.getId()).content(newUserAsJSON)
					.accept(MediaType.APPLICATION_JSON_VALUE)
					.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testGetCurrentUserSuccess() throws Exception {
		mockMvc.perform(get("/api/users/me")
					.with(SecurityMockMvcRequestPostProcessors.httpBasic("guto@guto.com", "123")))
				.andExpect(status().isOk())
				.andExpect(jsonPath("email").value("guto@guto.com"));
	}
	
	@Test
	public void testLoginSuccess() throws Exception {
		mockMvc.perform(post("/api/users/login")
					.param("email", "staff@fatecando.com")
					.param("password", "123")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("fullName").value("New Name"))
				.andExpect(jsonPath("email").value("staff@fatecando.com"))
				.andExpect(jsonPath("password").doesNotExist())
				.andExpect(jsonPath("userActivity").exists())
				.andDo(print());
	}
	
}
