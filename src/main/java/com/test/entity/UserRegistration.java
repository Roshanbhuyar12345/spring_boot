package com.test.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "user_regi")
public class UserRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private  Date created_at;
	
	private Date updated_at;
	
	private boolean is_active=true;
	
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public UserRegistration(int id, String name, String email, String password, Date created_at, Date updated_at,
			boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.is_active = is_active;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}



	@Override
	public String toString() {
		return "UserRegistration [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", is_active=" + is_active + "]";
	}

	

}
