package com.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;


@Entity
@Table(name = "role_permission") 
@Where(clause = "is_active=true")
//@SQLDelete(sql = "UPDATE role_permission u SET is_active=false WHERE u.role_id=? AND  u.permission_id=?")
public class RolePermissionEntity {

	private Date createdAt;
	
	private Date updatedAt;
	
	private boolean isActive=true;
	
	RolePermissionId pk=new RolePermissionId();
	
	

	public RolePermissionEntity(Date createdAt, Date updatedAt, boolean isActive, RolePermissionId pk) {
		super();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
		this.pk = pk;
	}

	public RolePermissionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    @Column(name = "created_at")
    @CreationTimestamp
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	 @Column(name = "updated_at")
	 @UpdateTimestamp
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    @Column(name = "is_active")
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
    @EmbeddedId
	public RolePermissionId getPk() {
		return pk;
	}

	public void setPk(RolePermissionId pk) {
		this.pk = pk;
	}
	
	
	
}
