package com.test.repository;

 
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.entity.*;


@Repository
public interface UserRoleEntityRepo extends JpaRepository<UserRoleEntity, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE user_role u SET active=false WHERE u.role_id=:role_id AND  u.user_id=:user_id",nativeQuery = true)
	void deleteRole(@Param("role_id") int role_id,@Param("user_id") int user_id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE user_role u SET role_id=:role_id WHERE u.user_id=:user_id",nativeQuery = true)
	void updateUserRole(@Param("role_id") int role_id,@Param("user_id") int user_id);
	
	
}
 