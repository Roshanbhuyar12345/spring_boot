package com.test.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.RoleEntityRepo;
import com.test.dto.RoleDto;
import com.test.entity.RoleEntity;

@Service
public class RoleEntityService {
	
	@Autowired
	private RoleEntityRepo roleEntityRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//adding role
	public RoleEntity addRole(RoleDto roleDto) {
		
		RoleEntity roleEntity=new RoleEntity();
		
		roleEntity.setRoleName(roleDto.getRoleName());
		
		roleEntity.setDescription(roleDto.getDescription());
		
		return this.roleEntityRepo.save(roleEntity);
		
	}
	
	
	//read roles by id
public RoleDto getById(int id) {
	
	Optional<RoleEntity> roleEntity=this.roleEntityRepo.findById(id);
	
	return this.roleToRoledto(roleEntity);
	
}
	
//READ All User

public List<RoleEntity> getAllRole(){

	List<RoleEntity> list=this.roleEntityRepo.findAll();
	
	return list;
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//roleEntity to roledto
	
	public RoleDto roleToRoledto(Optional<RoleEntity> roleEntity) {
		
		RoleDto roleDto=this.modelMapper.map(roleEntity, RoleDto.class);
		
		return roleDto;
		
	}
	
	//RoleDto to RoleEntity
	public RoleEntity roleDtoToRoleEntiry(RoleDto roleDto) {
		RoleEntity roleEntity=this.modelMapper.map(roleDto, RoleEntity.class);
		
		return roleEntity;
	}
	

}
