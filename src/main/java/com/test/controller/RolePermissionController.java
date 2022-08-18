package com.test.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.RolePermissionDto;
import com.test.dto.SuccessResponce;
import com.test.entity.RolePermissionEntity;
import com.test.exception.ErrorDetail;
import com.test.service.RolePermissionEntityService;

@RestController
public class RolePermissionController {

	@Autowired
	private RolePermissionEntityService rolePermissionEntityService;

	@PostMapping("/rolePermission")
	public ResponseEntity<?> addPermissionToRole(@RequestBody RolePermissionDto dto) {
		try {
			this.rolePermissionEntityService.addPermissionToRole(dto);

			return ResponseEntity.ok("Permission Assign To role Succefully !!");
		} catch (Exception e) {

			return ResponseEntity.ok(
					new ErrorDetail(new Date(), "Invalid Role Or Permission Put", "Oppss sorry !! try again", true));
		}

	}

	@PutMapping("/UpdatePermission")
	public ResponseEntity<?> updateRolePermission(@RequestBody RolePermissionDto dto) {
		try {
			this.rolePermissionEntityService.updatePermisssionRole(dto);

			return ResponseEntity.ok("Update Permission !!");
		} catch (Exception e) {
			return ResponseEntity.ok(
					new ErrorDetail(new Date(), "Invalid Role Or Permission Put", "Oppss sorry !! try again", true));
		}
	}

	@GetMapping("/rolePermission")
	public ResponseEntity<?> getAllPermissionRole() {
		try {
			List<RolePermissionEntity> list = this.rolePermissionEntityService.getPermissionRole();

			return ResponseEntity.ok(new SuccessResponce("Role Permmission", "Success", list));
		} catch (Exception e) {
			return ResponseEntity.ok(
					new ErrorDetail(new Date(), "Invalid Role Or Permission Put", "Oppss sorry !! try again", true));
		}
	}

	@DeleteMapping("/rolePermission")
	public ResponseEntity<?> deleteRolePermission(@RequestBody RolePermissionDto dto) {

		try {
			this.rolePermissionEntityService.deleteRolePermission(dto);

			return ResponseEntity.ok("Delete Succefully !!");
		} catch (Exception e) {

			return ResponseEntity.ok(new ErrorDetail(new Date(), "Wrong Role Or Permission", "Sorry id Wrongg", true));

		}

	}

}
