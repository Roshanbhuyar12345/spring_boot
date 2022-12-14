package com.test.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
 
@Embeddable
public class RolePermissionId implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RoleEntity role;
	
	private PermissionEntity permission;

	public RolePermissionId(RoleEntity role, PermissionEntity permission) {
		super();
		this.role = role;
		this.permission = permission;
	}

	public RolePermissionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	@ManyToOne
	public PermissionEntity getPermission() {
		return permission;
	}

	public void setPermission(PermissionEntity permission) {
		this.permission = permission;
	}
	
	
}
