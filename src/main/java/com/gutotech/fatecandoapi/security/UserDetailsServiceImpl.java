package com.gutotech.fatecandoapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gutotech.fatecandoapi.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.gutotech.fatecandoapi.model.User user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid email or password!");
		}

		return new User(user.getEmail(), user.getPassword(), user.getRoles());
	}

}