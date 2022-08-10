package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.RoleEntityRepo;
import com.test.Repository.UserLoginRepo;
import com.test.Repository.UserRoleEntityRepo;
import com.test.dto.UserRole123Dto;
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
	public void addRole( UserRole123Dto dto) {
		ArrayList<UserRoleEntity> list=new ArrayList<UserRoleEntity>();
		User user1 = this.userLoginRepo.findByUsername(dto.getUser());
		System.out.println("USER " + user1.getId());
        RoleEntity roleEntity = this.roleEntityRepo.findByRoleName(dto.getRole());
        System.out.println("ROLE " + roleEntity.getId());
        UserRoleId newUserRoleEntity = new UserRoleId(user1, roleEntity);
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUri(newUserRoleEntity);
        list.add(userRoleEntity);
		userRoleEntityRepo.saveAll(list);


	}
	
	
	//get all user role
	public List<UserRoleEntity> getAll(){
		
	List<UserRoleEntity> entity=this.userRoleEntityRepo.findAll();
	
	System.out.println(entity);
		
	return entity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
