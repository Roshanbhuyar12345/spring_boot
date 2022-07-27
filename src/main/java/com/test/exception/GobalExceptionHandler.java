package com.test.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception,  WebRequest request){
	
	ErrorDetail error=new ErrorDetail(new Date(), exception.getMessage(), request.getDescription(false), true);
	
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}

