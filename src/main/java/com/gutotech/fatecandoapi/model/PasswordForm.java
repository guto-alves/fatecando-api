package com.gutotech.fatecandoapi.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PasswordForm {

	@NotBlank
	private String password;
	
	@NotBlank
	@Size(min = 4)
	private String newPassword;
	
	@NotBlank
	@Size(min = 4)
	private String confirmNewPassword;

	public PasswordForm() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmPassword) {
		this.confirmNewPassword = confirmPassword;
	}

}
