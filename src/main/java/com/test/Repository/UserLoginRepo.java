 package com.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.User;

@Repository
public interface UserLoginRepo extends JpaRepository<User, Integer>{

	
	
	public User findByUsername(String userName);
	
	public User findByUsername(User userName);
	
	 
	
}
