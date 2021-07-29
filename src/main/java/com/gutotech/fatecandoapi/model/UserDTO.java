package com.gutotech.fatecandoapi.model;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserDTO {
	private Long id;

	@NotBlank
	@Size(min = 2)
	private String fullName;

	@Email
	private String email;

	@NotBlank
	@Size(min = 4)
	private String password;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birthDate;

	public UserDTO() {
	}
	
	public UserDTO(User user) {
		id = user.getId();
		fullName = user.getFullName();
		email = user.getEmail();
		password = user.getPassword();
		gender = user.getGender();
		birthDate = user.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
