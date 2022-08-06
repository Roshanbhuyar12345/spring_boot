package com.test.entity;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user_role")
//@AssociationOverrides({ @AssociationOverride(name = "uri.user", joinColumns = @JoinColumn(name = "user_id")), @AssociationOverride(name = "uri.role", joinColumns = @JoinColumn(name = "role_id")) })
public class UserRoleEntity {
	
	
	
	
	
	public UserRoleEntity(Object object) {
		super();
		// TODO Auto-generated constructor stub
	}


	private UserRoleId uri=new UserRoleId();

	private boolean isActive=true;
	 
	@EmbeddedId
	 public UserRoleId getUri() {
		return uri;
	}


	public void setUri(UserRoleId uri) {
		this.uri = uri;
	}


	@CreationTimestamp
	 private Date createdAt;
	
	 
	 @UpdateTimestamp
	 private Date updatedAt;

	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	 
	 

}
