package com.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.test.entity.LoggerEntity;

public interface LoggerRepo extends JpaRepository<LoggerEntity, Integer> {
	
	
	LoggerEntity findByToken(String token);
	
	void removeByToken(String token);
	
	
	


}
