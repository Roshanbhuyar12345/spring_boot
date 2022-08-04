package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.RoleDto;
import com.test.entity.RoleEntity;
import com.test.service.RoleEntityService;

@RestController
@RequestMapping("/api")
public class RoleController {

	
	@Autowired
	private RoleEntityService roleEntityService;
	
	@PostMapping("/role")
	public ResponseEntity<?> addRole(@RequestBody RoleDto roleDto){
	
	RoleEntity roleEntity=	this.roleEntityService.addRole(roleDto);
		
		return new ResponseEntity<>(roleEntity,HttpStatus.CREATED);
		
	}
	//read by id
	@GetMapping("/role/{id}")
	public ResponseEntity<?> grtRoleById(@PathVariable("id") int id){
		
		return ResponseEntity.ok(this.roleEntityService.getById(id));
		
	}
	//Read All Roles
	@GetMapping("/roles")
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.ok(this.roleEntityService.getAllRole());
		
	}
	

}