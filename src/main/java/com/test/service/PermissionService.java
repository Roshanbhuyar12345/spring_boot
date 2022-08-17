package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.PermissionDto;
import com.test.dto.PermissionRequestDto;
import com.test.dto.UserDto;
import com.test.entity.PermissionEntity;
import com.test.entity.User;
import com.test.repository.PermissionRepo;
import com.test.repository.RoleEntityRepo;
import com.test.repository.UserLoginRepo;
import com.test.repository.UserRoleEntityRepo;

@Service
public class PermissionService {
	
	@Autowired
	private PermissionRepo permissionRepo;
	
	@Autowired
	private RoleEntityRepo roleEntityRepo;
	
	
	//post permission to user
	public PermissionEntity addPermissio(PermissionRequestDto permissionDto) {
		
		PermissionEntity permissionEntity=new PermissionEntity();
		
		  
		permissionEntity.setActionName(permissionDto.getActionName());
		permissionEntity.setDescription(permissionDto.getDescription());
		permissionEntity.setRoleId(roleEntityRepo.getById(permissionDto.getRoleId()));
		permissionEntity.setMethod(permissionDto.getMethod());
		permissionEntity.setPath(permissionDto.getPath());
		permissionEntity.setBaseUrl(permissionDto.getBaseUrl());
		
		this.permissionRepo.save(permissionEntity);
		
		return permissionEntity;
		
	}
	
	//get All Permission roles
	public List<PermissionEntity> getPermission(){
		
		List<PermissionEntity> list= this.permissionRepo.findAll();
		
		return list;
		
	}

}
