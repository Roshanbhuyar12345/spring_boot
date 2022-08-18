package com.test.dto;

public class RolePermissionDto {

	private String role;
	
	private String Permission;

	public RolePermissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolePermissionDto(String role, String permission) {
		super();
		this.role = role;
		Permission = permission;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPermission() {
		return Permission;
	}

	public void setPermission(String permission) {
		Permission = permission;
	}
	
	
	
}
