package com.gutotech.fatecandoapi.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.RoleRepository;
import com.gutotech.fatecandoapi.repository.UserRepository;
import com.gutotech.fatecandoapi.rest.ResourceNotFoundException;
import com.gutotech.fatecandoapi.security.Roles;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	public User findById(Long id) {
		return repository.findById(id) //
				.orElseThrow(() -> new ResourceNotFoundException("Could not find user " + id));
	}

	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

	public List<User> findByNameOrEmail(String filter) {
		return repository.findByFullNameOrEmailContaining(filter);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User save(User user) {
		return repository.save(user);
	}

	public void registerAll(List<User> users) {
		users.forEach(this::register);
	}

	public User register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(Arrays.asList(roleRepository.findByName(Roles.STUDENT)));
		user.setEnabled(true);
		return repository.save(user);
	}

	public User login(String email, String rawPassword) {
		User user = repository.findByEmail(email);

		if (user != null && passwordEncoder.matches(rawPassword, user.getPassword())) {
			user.setLastLogin(new Date());
			repository.save(user);
			return user;
		}

		return null;
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public User findCurrentUser() {
		return findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
	public boolean isCurrentUserAdmin() {
		return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(Roles.ADMIN));
	}
	
	public boolean hasRoles(String... roles) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return roles != null && auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken) &&
				auth.getAuthorities().stream().anyMatch(a -> Arrays.asList(roles).contains(a.getAuthority()));
	}
	
}
