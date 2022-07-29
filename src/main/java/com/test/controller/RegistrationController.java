package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.UserRegistration;
import com.test.service.UserRegisService;

@RestController
@RequestMapping("/user")
public class RegistrationController {
	
	@Autowired
	private UserRegisService regisService;
	
	
	@PostMapping("/registration")
	public ResponseEntity<?> addNewUser(@RequestBody UserRegistration registration){
	
		UserRegistration registration2=this.regisService.addNewUser(registration);
		
		return new ResponseEntity(registration2,HttpStatus.CREATED);
		
		
	}
	

}
