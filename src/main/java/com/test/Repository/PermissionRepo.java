package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.PermissionEntity;

@Repository
public interface PermissionRepo extends JpaRepository<PermissionEntity, Integer>{
	
	public PermissionEntity findByactionName(String actionName);

}
