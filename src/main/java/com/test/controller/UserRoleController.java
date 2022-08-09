package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
//	@PostMapping(value = "/assignRole", consumes = MediaType.APPLICATION_JSON_VALUE)
//	@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE,path = "/assignRole")
 	@PostMapping(value = "/assignRole", consumes = {"application/json"})
	public ResponseEntity<UserRoleEntity> assignRole(@RequestBody UserRole123Dto dto){
		
		UserRoleEntity roleEntity=	this.userRoleService.addRole(dto);
		
		return new ResponseEntity<>(roleEntity, HttpStatus.CREATED);
	}
	
}
