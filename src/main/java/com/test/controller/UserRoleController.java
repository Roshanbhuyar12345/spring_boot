package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.UserRole123Dto;
import com.test.entity.RoleEntity;
import com.test.entity.User;
import com.test.entity.UserRoleEntity;
import com.test.service.UserRoleService;

@RestController
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	
	@PostMapping("/assignRole")
	public ResponseEntity<UserRoleEntity> assignRole(@RequestBody UserRole123Dto dto){
		UserRoleEntity roleEntity=	this.userRoleService.addRole(dto);
		
		return new ResponseEntity<>(roleEntity, HttpStatus.CREATED);
	}
	
	
	
}
