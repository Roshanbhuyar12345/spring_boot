package com.test.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.SuccessResponce;
import com.test.dto.UserRole123Dto;
import com.test.entity.UserRoleEntity;
import com.test.exception.ErrorDetail;
import com.test.service.UserRoleService;

@RestController
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@PostMapping(value = "/assignRole", consumes = { "application/json" })
	public ResponseEntity<?> assignRole(@RequestBody UserRole123Dto dto) throws Exception {

		try {
			this.userRoleService.addRole(dto);

			return ResponseEntity.ok("Role Assign Sucessfuly");

		} catch (Exception e) {
			return ResponseEntity.ok("Sorry !! User or Role May Not Found , Try Again");
		}

	}

	@PutMapping("/updateRole")
	public ResponseEntity<?> update(@RequestBody UserRole123Dto dto) {

		try {

			this.userRoleService.updateRole(dto);

			return new ResponseEntity<>("updated !!", HttpStatus.ACCEPTED);

		} catch (Exception e) {
			return new ResponseEntity<>(
					new ErrorDetail(new Date(), "User Already Exist", "Already there please try anathor role", true),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteRole")

	public ResponseEntity<?> deleteUserRole(@RequestBody UserRole123Dto dto) {

		this.userRoleService.deleteRole(dto);

		return ResponseEntity.ok("Delete SUccefully");

	}

	@GetMapping("/AllUserRole")
	public ResponseEntity<?> getAllUserRole() {

		List<UserRoleEntity> list = this.userRoleService.getAllUserRole();

		return ResponseEntity.ok(new SuccessResponce("All User Roles", "Users and there Roles", list));

	}

}
