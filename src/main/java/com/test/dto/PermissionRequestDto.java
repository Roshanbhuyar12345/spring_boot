package com.test.dto;

import java.io.Serializable;

public class PermissionRequestDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String actionName;
	private String description;
	private String baseUrl;
	private String method;
	private int roleId;
	private String path;
	public PermissionRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 

	public PermissionRequestDto(String actionName, String description, String baseUrl, String method, Integer roleId,
			String path) {
		super();
		this.actionName = actionName;
		this.description = description;
		this.baseUrl = baseUrl;
		this.method = method;
		this.roleId = roleId;
		this.path = path;
	}



	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	 
	 

	public Integer getRoleId() {
		return roleId;
	}



	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}



	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	 
	
	

}
