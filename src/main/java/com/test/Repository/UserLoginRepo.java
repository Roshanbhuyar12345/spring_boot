package com.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.UserLogin;
import com.test.entity.UserRegistration;

@Repository
public interface UserLoginRepo extends JpaRepository<UserLogin, Integer>{

	UserLogin findByUserName(String userName);
	
}
