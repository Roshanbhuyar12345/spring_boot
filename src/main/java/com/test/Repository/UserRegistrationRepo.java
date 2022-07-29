package com.test.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.UserRegistration;
@Repository
public interface UserRegistrationRepo extends JpaRepository<UserRegistration,Integer> {

	UserRegistration findByName(String name);
	
	Optional<UserRegistration> findById(Integer id);
	
	UserRegistration findByemail(String email);
	
}
