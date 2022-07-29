package com.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.test.Repository.UserRegistrationRepo;
import com.test.entity.UserRegistration;

@Service
public class UserRegisService {
	
	@Autowired
	private UserRegistrationRepo registrationRepo;
	
	//register or add new user
	public UserRegistration addNewUser(UserRegistration newUser) {
		
		UserRegistration registration=this.registrationRepo.save(newUser);
		
		return registration;
		
		
	}
	
	
	
	public Optional<UserRegistration> findById(int id) throws ResourceAccessException{
		
		Optional<UserRegistration> registration=this.registrationRepo.findById(id);
		
		return registration;
		
	}
	
	
	public UserRegistration findByEmail(String email) {
		
		UserRegistration userRegistration=this.registrationRepo.findByemail(email);
		
		return userRegistration;
		
	}
	
	
	public UserRegistration findByName(String name) {
		UserRegistration registration=this.registrationRepo.findByName(name);
		
		return registration;
	}
	
	

}
