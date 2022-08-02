package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.LoggerRepo;
import com.test.dto.LoggerDto;
import com.test.entity.LoggerEntity;
import com.test.entity.User;

@Service
public class LoggerEntityService {
	
	@Autowired
	private LoggerRepo loggerRepo;
	
	public void createLogger(LoggerDto loggerDto,Integer id) {
		LoggerEntity logger=new LoggerEntity();
		
		logger.setUserId(id);
		logger.setToken(loggerDto.getToken());
		logger.setExpireAt(loggerDto.getExpireAt());
		loggerRepo.save(logger);
		
	}
	
	//logout user
	public void LogoutUser(String token) {
		
		System.out.println(token);
		
		final String userToken=token.substring(7);
		
		
		this.loggerRepo.removeByToken(userToken);
	   
	    
		
	}
	

}
