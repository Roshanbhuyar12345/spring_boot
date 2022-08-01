package com.test.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.Repository.UserLoginRepo;
import com.test.confi.jwtTokenUtil;
import com.test.dto.LoggerDto;
import com.test.dto.UserDto;
import com.test.entity.JwtRequest;
import com.test.entity.JwtResponce;
import com.test.entity.User;
import com.test.service.JwtUserDetailsService;
import com.test.service.LoggerEntityService;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private jwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userdetailsService;

	@Autowired
	private UserLoginRepo userRepo;

	@Autowired
	private LoggerEntityService loggerEntityService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		try {
			System.out.println("Hey Spring !!");

			User user = userRepo.findByUsername(authenticationRequest.getUsername());

			if (userdetailsService.comparePassword(authenticationRequest.getPassword(), user.getPassword())) {

				final UserDetails userDetails = userdetailsService
						.loadUserByUsername(authenticationRequest.getUsername());
				final User user1 = userRepo.findByUsername(authenticationRequest.getUsername());

				final String token = this.jwtTokenUtil.generateToken(userDetails);

				LoggerDto loggerDto = new LoggerDto();
				loggerDto.setToken(token);

				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.HOUR_OF_DAY, 5);
				loggerDto.setExpireAt(calendar.getTime());

				this.loggerEntityService.createLogger(loggerDto, user1.getId());

				return ResponseEntity.ok(new JwtResponce(token));
			} else {
				throw new Exception("Invalid usename or password.");
			}

		} catch (Exception e) {
			System.out.printf("Invalid usename or password ", e);

		}
		return ResponseEntity.ok("Invalid usename or password");

	}
	
	

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) throws Exception {
		System.out.println(userDto.toString());
		return ResponseEntity.ok(userdetailsService.save(userDto));
	}

}
