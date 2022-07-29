package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.confi.jwtTokenUtil;
import com.test.dto.UserDto;
import com.test.entity.JwtRequest;
import com.test.entity.JwtResponce;
import com.test.entity.UserRegistration;
import com.test.service.JwtUserDetailsService;

@RestController
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private jwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userdetailsService;
	
	@RequestMapping(value = "/authenticate",method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception{
		
		authenticate(authenticationRequest.getUser_Name(),authenticationRequest.getPassword());
		
		final UserDetails userDetails=userdetailsService.loadUserByUsername(authenticationRequest.getUser_Name());
		
		final String token=this.jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponce(token) );
		
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) throws Exception{
		
		return  ResponseEntity.ok(userdetailsService.save(userDto));
	}
	
	
	
	
	private void authenticate (String username,String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			throw new Exception("User Disable",e);
		}catch(BadCredentialsException e) {
			throw new Exception("Ivalid Creadential");
		}
	}
	
	
	
	
	
}
