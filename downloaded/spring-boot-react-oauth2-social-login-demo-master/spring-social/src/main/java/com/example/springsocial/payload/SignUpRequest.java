package com.example.springsocial.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SignUpRequest {
	@NotBlank
	private String name;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	private String userType;

	private String enterpriseName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public final String getUserType() {
		return userType;
	}

	public final void setUserType(String userType) {
		this.userType = userType;
	}

	public final String getEnterpriseName() {
		return enterpriseName;
	}

	public final void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
}
