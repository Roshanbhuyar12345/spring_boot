package com.test.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user_role")
public class UserRoleEntity {
	
	@EmbeddedId
	private UserRoleId uri=new UserRoleId();
	
	 private boolean isActive=true;
	 
	 @CreationTimestamp
	 private Date createdAt;
	
	 
	 @UpdateTimestamp
	 private Date updatedAt;


	public UserRoleId getUri() {
		return uri;
	}


	public void setUri(UserRoleId uri) {
		this.uri = uri;
	}


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
