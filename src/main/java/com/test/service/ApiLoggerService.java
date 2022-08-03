package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Repository.ApiLoggerRepo;
import com.test.entity.ApiLoggerEntity;

@Service
public class ApiLoggerService {

	public ApiLoggerService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private ApiLoggerRepo apiLoggerRepo;
	
	
	public void createApiLog(ApiLoggerEntity api) {
		this.apiLoggerRepo.save(api);
		
	}
	
	

}
