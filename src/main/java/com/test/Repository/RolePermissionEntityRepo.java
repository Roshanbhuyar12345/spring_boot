package com.test.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.entity.RolePermissionEntity;

@Repository
public interface RolePermissionEntityRepo extends JpaRepository<RolePermissionEntity, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE role_permission u SET permission_id=:permission_id WHERE u.role_id=:role_id",nativeQuery = true)
	void updateRolePermission(@Param("role_id") int role_id,@Param("permission_id") int permission_id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE role_permission u SET is_active=false WHERE u.role_id=? AND  u.permission_id=?",nativeQuery = true)
	void deleteRolePermission(@Param("role_id") int role_id ,@Param("permission_id") int permission_id);
}
