package com.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.IPermissionIdList;
import com.test.dto.RoleDto;
import com.test.dto.RoleIdListDto;
import com.test.entity.RoleEntity;
 import com.test.entity.User;
import com.test.entity.UserRoleEntity;
import com.test.repository.RoleEntityRepo;
import com.test.repository.RolePermissionEntityRepo;
import com.test.repository.UserLoginRepo;
import com.test.repository.UserRoleEntityRepo;

@Service
public class RoleEntityService {

	@Autowired
	private RoleEntityRepo roleEntityRepo;

	@Autowired
	private UserLoginRepo userLoginRepo;
	
	@Autowired
	private UserRoleEntityRepo userRoleEntityRepo;

	@Autowired
	private RolePermissionEntityRepo rolePermissionEntityRepo;

	@Autowired
	private ModelMapper modelMapper;

	// adding role
	public RoleEntity addRole(RoleDto roleDto) {

		RoleEntity roleEntity = new RoleEntity();

		roleEntity.setRoleName(roleDto.getRoleName());

		roleEntity.setDescription(roleDto.getDescription());

		return this.roleEntityRepo.save(roleEntity);

	}

	// read roles by id
	public RoleDto getById(int id) {

		Optional<RoleEntity> roleEntity = this.roleEntityRepo.findById(id);

		return this.roleToRoledto(roleEntity);

	}

	// READ All User

	public List<RoleEntity> getAllRole() {

		List<RoleEntity> list = this.roleEntityRepo.findAll();

		return list;

	}

	// Update Role

	public RoleEntity updateRole(RoleEntity roleEntity, int id) {

		this.roleEntityRepo.findById(id);

		roleEntity.setRoleName(roleEntity.getRoleName());
		roleEntity.setDescription(roleEntity.getDescription());

		RoleEntity roleEntity2 = this.roleEntityRepo.save(roleEntity);

		return roleEntity2;

	}

	// delete Role

	public void deleteRole(int id) {

		this.roleEntityRepo.findById(id);

		this.roleEntityRepo.deleteById(id);

	}

	// adding role to user
	public void addRoleToUser(String username, String roleName) {

		User user = this.userLoginRepo.findByUsername(username);
		System.out.println("user>>" + username);

		RoleEntity role = roleEntityRepo.findByRoleName(roleName);
		System.out.println("role>>" + role);

	}
//geting permission by userId
	public ArrayList<String> getPermissionByUserId(Integer id){
		
		ArrayList<UserRoleEntity> roleId=this.userRoleEntityRepo.getRolesOfUser(id);
		
		ArrayList<Integer> roles=new ArrayList<Integer>();
		
		for(int i=0;i< roleId.size();i++) {
			
			roles.add(roleId.get(i).getUri().getRole().getId());
		}

		List<IPermissionIdList> entities=this.rolePermissionEntityRepo.findPkPermissionByPkRoleIdIn(roles, IPermissionIdList.class);

		ArrayList<String> permission=new ArrayList<String>();
		
		for(IPermissionIdList list:entities) {
			permission.add(list.getPkPermissionActionName());
		}

		return permission;
		
	}
	

	// roleEntity to roledto

	public RoleDto roleToRoledto(Optional<RoleEntity> roleEntity) {

		RoleDto roleDto = this.modelMapper.map(roleEntity, RoleDto.class);

		return roleDto;

	}

	// RoleDto to RoleEntity
	public RoleEntity roleDtoToRoleEntiry(RoleDto roleDto) {
		RoleEntity roleEntity = this.modelMapper.map(roleDto, RoleEntity.class);

		return roleEntity;
	}

}
