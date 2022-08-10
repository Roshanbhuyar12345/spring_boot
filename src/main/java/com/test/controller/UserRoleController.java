package com.test.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.UserRole123Dto;
import com.test.entity.UserRoleEntity;
import com.test.service.UserRoleService;

@RestController  
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@PostMapping(value = "/assignRole", consumes = { "application/json" })
	public ResponseEntity<?> assignRole(@RequestBody UserRole123Dto dto) throws Exception 
	{

		try 
		{
		this.userRoleService.addRole(dto);

		return ResponseEntity.ok("Role Assign Sucessfuly");
		
		}
		catch(Exception e) 
		{
			return ResponseEntity.ok("Sorry !! User or Role May Not Found , Try Again");
		}
		
	}

	
	@GetMapping("/GetAllRoles")
	public ResponseEntity<?> getAllRoles(UserRoleEntity entity){
		
	 List<UserRoleEntity> entities=	 this.userRoleService.getAll();
		
		return new ResponseEntity<>("hey sanket",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	
	
	
	
}
