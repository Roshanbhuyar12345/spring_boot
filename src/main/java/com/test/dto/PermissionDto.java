package com.test.dto;

public class PermissionDto {

	private int id;
	
	private String actionName;
	
	private String description;

	public PermissionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermissionDto(int id, String actionName, String description) {
		super();
		this.id = id;
		this.actionName = actionName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "PermissionDto [id=" + id + ", actionName=" + actionName + ", description=" + description + "]";
	}
	
	
	
	
}
