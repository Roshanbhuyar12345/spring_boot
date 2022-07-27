package com.test.dto;

public class UserDto {
	
	private String user_Name;
	
	private String password;

	public UserDto(String user_Name, String password) {
		super();
		this.user_Name = user_Name;
		this.password = password;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [user_Name=" + user_Name + ", password=" + password + "]";
	}
	
	

}
