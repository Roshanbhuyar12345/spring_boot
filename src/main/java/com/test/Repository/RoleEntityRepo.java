package com.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.RoleEntity;


@Repository
public interface RoleEntityRepo extends JpaRepository<RoleEntity,Integer > {


   RoleEntity findByRoleName(String roleName);
	
//   RoleEntity findByRoleName(RoleEntity roleName);
   
 }
