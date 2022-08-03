package com.test.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.test.service.ApiLoggerService;
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{

	public WebMvcConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private ApiLogger apiLogger;
	
	public void addInterceptor(InterceptorRegistry registry) {
		
		registry.addInterceptor(apiLogger).addPathPatterns("/auth/*/**");
		
	}
	
	
	
	

}
