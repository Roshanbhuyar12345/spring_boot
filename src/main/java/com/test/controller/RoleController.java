package com.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	//Update Role
	@PutMapping("/role/{id}")
	public ResponseEntity<?> updateRole(@RequestBody RoleEntity roleEntity,@PathVariable("id") int id){
		
		RoleEntity entity= this.roleEntityService.updateRole(roleEntity, id);
		
		return new ResponseEntity<>("Sucessfully updated ",HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/role/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable("id") int id){
		
		this.roleEntityService.deleteRole(id);
		
		return ResponseEntity.ok("Delete Sucessfully");
		
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getPermissiobByUserId(@PathVariable("id") int id){
		
	ArrayList<String> user=	this.roleEntityService.getPermissionByUserId(id);
		
		return ResponseEntity.ok(user);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
