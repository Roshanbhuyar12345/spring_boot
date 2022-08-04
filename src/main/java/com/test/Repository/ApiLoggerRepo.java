package com.test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.entity.ApiLoggerEntity;

@Repository
public interface ApiLoggerRepo extends JpaRepository<ApiLoggerEntity, Integer> {
	

}