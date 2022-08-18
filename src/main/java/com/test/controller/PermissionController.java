package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.PermissionDto;
import com.test.dto.PermissionRequestDto;
import com.test.dto.SuccessResponce;
import com.test.dto.UserDto;
import com.test.entity.PermissionEntity;
import com.test.entity.User;
import com.test.service.PermissionService;

@RestController
public class PermissionController {

	@Autowired
	private PermissionService permissionService;

	@PostMapping("/permission")
	public ResponseEntity<?> addPermissions(@RequestBody PermissionRequestDto permissionRequestDto) {

		PermissionEntity dto = this.permissionService.addPermissio(permissionRequestDto);

		return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);

	}

	@GetMapping("/permission")
	public ResponseEntity<?> getPermission() {

		List<PermissionEntity> list = this.permissionService.getPermission();

		return ResponseEntity.ok(new SuccessResponce("All permission", "Prmission and Role", list));

	}
	
	@GetMapping("/permission/{id}")
	public ResponseEntity<?> getPermissionId( @PathVariable("id") int id){
		PermissionEntity entity= this.permissionService.getPemissionById(id);
		return new ResponseEntity<>(new SuccessResponce("Permission Id", "Permission ", entity),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/permission/{id}")
	public ResponseEntity<?> updatePermission(@RequestBody PermissionRequestDto dto,@PathVariable("id") int id){
	PermissionEntity entity=	this.permissionService.updatePermission(dto, id);
	return new ResponseEntity<>(entity,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/permission/{id}")
	public ResponseEntity<?>  deletePermission(@PathVariable("id") int id){
		this.permissionService.deletePermission(id);
		return ResponseEntity.ok("Delete Succefully !!");
		
	}
	
	
	
	
	
	
	

}
