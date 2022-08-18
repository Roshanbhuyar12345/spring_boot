package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.PermissionDto;
import com.test.dto.PermissionRequestDto;
import com.test.dto.UserDto;
import com.test.entity.PermissionEntity;
import com.test.entity.User;
import com.test.exception.ResourceNotFoundException;
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

	//get Permission by Id 
	public PermissionEntity getPemissionById(int id ) {
		
		PermissionEntity entity=	 this.permissionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id Not Found"));
		
		return entity;
		
	}
	
	
	//Update Permission By Id
	public PermissionEntity updatePermission(PermissionRequestDto permissionRequestDto, int id) {
	PermissionEntity entity=	this.permissionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
	
	entity.setActionName(permissionRequestDto.getActionName());
	entity.setDescription(permissionRequestDto.getDescription());
	entity.setMethod(permissionRequestDto.getMethod());
	entity.setBaseUrl(permissionRequestDto.getBaseUrl());
	entity.setPath(permissionRequestDto.getPath());
	this.permissionRepo.save(entity);
	
	return entity;
	
	
	
	}
	
	
	//delete permission 
	public PermissionEntity deletePermission(int id) {
		PermissionEntity entity=this.permissionRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found"));
		this.permissionRepo.deleteById(id);
		return entity;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
