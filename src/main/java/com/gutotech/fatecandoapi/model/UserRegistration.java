package com.gutotech.fatecandoapi.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistration {
	@NotBlank
	@Size(min = 2)
	private String fullName;

	@Email
	private String email;

	@NotBlank
	@Size(min = 4)
	private String password;

	public UserRegistration() {
	}

	public UserRegistration(User user) {
		fullName = user.getFullName();
		email = user.getEmail();
		password = user.getPassword();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
