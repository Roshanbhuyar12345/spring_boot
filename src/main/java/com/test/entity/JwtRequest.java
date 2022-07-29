package com.test.entity;

import java.io.Serializable;

public class JwtRequest implements Serializable{

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String user_Name;
	private String password;
	
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JwtRequest(String user_Name, String password) {
		super();
		this.user_Name = user_Name;
		this.password = password;
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
	
	

}
