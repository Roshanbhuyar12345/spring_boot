package com.test.repository;

 
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.dto.RoleDto;
import com.test.dto.RoleIdListDto;
import com.test.entity.*;


@Repository
public interface UserRoleEntityRepo extends JpaRepository<UserRoleEntity, Integer>{

	@Query(value = "SELECT * FROM user_role u WHERE u.user_id=:user_id",nativeQuery = true)
	ArrayList<UserRoleEntity> getRolesOfUser(@Param("user_id") int userId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE user_role u SET role_id=:role_id WHERE u.user_id=:user_id",nativeQuery = true)
	void updateUserRole(@Param("role_id") int role_id,@Param("user_id") int user_id);
	
	
}
 