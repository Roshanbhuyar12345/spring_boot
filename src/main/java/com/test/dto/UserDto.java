package com.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserDto {
	
	private String username;
	

	private String password;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [username=" + username + ", password=" + password + "]";
	}

	public UserDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

}
