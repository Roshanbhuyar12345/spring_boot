package com.test.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Api_Logger")
public class ApiLoggerEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String userToken;
	
	private String ipAdress;
	
	private String url;
	
	private String host;
	
	private String body;
	@CreationTimestamp
	private Date createdAt;
	
	
	public ApiLoggerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ApiLoggerEntity(int id, String userToken, String ipAdress, String url, String host, String body,
			Date createdAt) {
		super();
		this.id = id;
		this.userToken = userToken;
		this.ipAdress = ipAdress;
		this.url = url;
		this.host = host;
		this.body = body;
		this.createdAt = createdAt;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserToken() {
		return userToken;
	}


	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}


	public String getIpAdress() {
		return ipAdress;
	}


	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
}
