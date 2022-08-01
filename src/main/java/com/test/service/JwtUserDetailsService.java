package com.test.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.test.Repository.*;
import com.test.dto.UserDto;
import com.test.entity.User;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private UserLoginRepo userLoginRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user= this.userLoginRepo.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	//for compaire password
	public Boolean comparePassword(String password, String hashPassword) {

		return passwordEncoder.matches(password, hashPassword);

	}
	
	public User save(UserDto user) {
		User ulogin=new User();
		ulogin.setUsername(user.getUsername());
		ulogin.setPassword(passwordEncoder.encode(user.getPassword().toString().trim()));
		//System.out.println(ulogin.getPassword());
		return userLoginRepo.save(ulogin);
		
	}

}
