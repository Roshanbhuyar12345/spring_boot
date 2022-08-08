package com.test.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "User_login_detail")
public class User  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_name", unique = true, nullable = true)
	private String username;
  
	@Column(nullable = true)
	private String password;
    
	@Column(name = "created_By")
	@CreationTimestamp
	private Date createdBy;
	
	@Column(name = "updeted_By")
	@UpdateTimestamp
	private Date updatedBy;
    
	@Column(name = "is_active")
	private boolean isActive=true;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "uri.user")
	private List<UserRoleEntity> userRole;
 
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}





	public User(int id, String username, String password, Date createdBy, Date updatedBy, boolean isActive,
			List<UserRoleEntity> userRole) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.isActive = isActive;
		this.userRole = userRole;
	}

	public List<UserRoleEntity> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRoleEntity> userRole) {
		this.userRole = userRole;
	}

	public Date getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}




	public String getUsername() {
		return username;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", isActive=" + isActive + "]";
	}

	

}
