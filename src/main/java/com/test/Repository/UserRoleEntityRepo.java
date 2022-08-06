package com.test.Repository;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.*;


@Repository
public interface UserRoleEntityRepo extends JpaRepository<UserRoleEntity, Integer>{

	//public UserRoleEntity addRole(User user, RoleEntity role);
	
//     UserRoleEntity findByOrderByAddRoles(User user,RoleEntity role);
}
