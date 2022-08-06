package com.test.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Embeddable
public class UserRoleId implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	private RoleEntity role;

	public UserRoleId(User user, RoleEntity role) {
		super();
		this.user = user;
		this.role = role;
	}

	public UserRoleId() {
		super(); 
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
	
	
	
	
	
	

}
