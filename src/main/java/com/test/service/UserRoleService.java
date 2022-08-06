package com.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.RoleEntityRepo;
import com.test.Repository.UserLoginRepo;
import com.test.Repository.UserRoleEntityRepo;
import com.test.entity.RoleEntity;
import com.test.entity.User;
import com.test.entity.UserRoleEntity;
import com.test.entity.UserRoleId;

@Service
public class UserRoleService {
	
	@Autowired
	private UserRoleEntityRepo userRoleEntityRepo;
	
	@Autowired
	private UserLoginRepo userLoginRepo;
	
	@Autowired
	private RoleEntityRepo roleEntityRepo;
	
	//Post UserRole
	public UserRoleEntity addRole(User user, RoleEntity role) {
		
		User user1=this.userLoginRepo.findByUsername(user);
		
		RoleEntity roleEntity=this.roleEntityRepo.findByRoleName(role);			
			
//		UserRoleEntity  userRoleEntity=   this.userRoleEntityRepo.findByOrderByAddRoles(user1, roleEntity);
		
//		UserRoleEntity roleEntities= this.userRoleEntityRepo.save(userRoleEntity);
		
		UserRoleId newUserRoleEntity = new UserRoleId();
		
		newUserRoleEntity.setUser(user1);
		
		newUserRoleEntity.setRole(roleEntity);
		
		UserRoleEntity userRoleEntity=new UserRoleEntity(newUserRoleEntity);
		
		
		
		userRoleEntityRepo.save(userRoleEntity);
		
		return userRoleEntity;
				
	}
	

}
