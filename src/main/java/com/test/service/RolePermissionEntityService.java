package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.RolePermissionDto;
import com.test.entity.PermissionEntity;
import com.test.entity.RoleEntity;
import com.test.entity.RolePermissionEntity;
import com.test.entity.RolePermissionId;
import com.test.repository.PermissionRepo;
import com.test.repository.RoleEntityRepo;
import com.test.repository.RolePermissionEntityRepo;

@Service
public class RolePermissionEntityService {
	
	@Autowired
	private RolePermissionEntityRepo permissionEntityRepo;
	
	@Autowired
	private RoleEntityRepo roleEntityRepo;
	
	@Autowired
	private PermissionRepo permissionRepo;
	
	//add permission to role
	public void addPermissionToRole(RolePermissionDto dto) {
		
		PermissionEntity permission=this.permissionRepo.findByactionName(dto.getPermission());
		 
		RoleEntity role=this.roleEntityRepo.findByRoleName(dto.getRole());
		
		RolePermissionId rolePermissionId=new RolePermissionId(role, permission);
		 
		RolePermissionEntity entity=new RolePermissionEntity();
		entity.setPk(rolePermissionId);
		
	    this.permissionEntityRepo.save(entity);
	    
		
	}
	
	//update permission  
	
	public void updatePermisssionRole(RolePermissionDto dto) {
		
		PermissionEntity permission=this.permissionRepo.findByactionName(dto.getPermission());
		 
		RoleEntity role=this.roleEntityRepo.findByRoleName(dto.getRole());
		
		RolePermissionId rolePermissionId=new RolePermissionId(role, permission);
		 
		RolePermissionEntity entity=new RolePermissionEntity();
		entity.setPk(rolePermissionId);
		
		this.permissionEntityRepo.updateRolePermission(role.getId(), permission.getId());
		
	}
	
	
	//Get all Role Permission
	
	public List<RolePermissionEntity> getPermissionRole() {
		
		List<RolePermissionEntity> list=this.permissionEntityRepo.findAll();
		
		return list;

	}
	
	
	//delete Permission
	
	public RolePermissionEntity deleteRolePermission(RolePermissionDto dto) {
		
		PermissionEntity permission=this.permissionRepo.findByactionName(dto.getPermission());
		 
		RoleEntity role=this.roleEntityRepo.findByRoleName(dto.getRole());
		
		RolePermissionId rolePermissionId=new RolePermissionId(role, permission);
		 
		RolePermissionEntity entity=new RolePermissionEntity();
		entity.setPk(rolePermissionId);
		
	    this.permissionEntityRepo.deleteRolePermission(role.getId(), permission.getId());
	    return entity;
		
	}
	
	

}
