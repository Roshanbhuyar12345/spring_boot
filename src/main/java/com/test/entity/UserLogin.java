package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_login_datail")
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String user_Name;
	
	private String password;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLogin(int id, String user_Name, String password) {
		super();
		this.id = id;
		this.user_Name = user_Name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "UserLogin [id=" + id + ", user_Name=" + user_Name + ", password=" + password + "]";
	}
	
	

}
