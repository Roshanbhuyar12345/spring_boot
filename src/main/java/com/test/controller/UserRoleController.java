package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.RoleEntity;
import com.test.entity.User;
import com.test.service.UserRoleService;

@RestController
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	
	@PostMapping("/assignRole")
	public ResponseEntity<?> assignRole(User user, RoleEntity role){
		
			this.userRoleService.addRole(user, role);
		
		return ResponseEntity.ok("assing succefully");
	}
	
	
	
}
