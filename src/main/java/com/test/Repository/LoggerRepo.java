package com.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.LoggerEntity;
@Repository
public interface LoggerRepo extends JpaRepository<LoggerEntity, Integer> {
	
	
	LoggerEntity findByToken(String token);
	
	void removeByToken(String token);
	
	
	


}
