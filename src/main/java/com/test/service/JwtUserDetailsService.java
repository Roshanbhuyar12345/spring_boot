package com.test.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.entity.UserLogin;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private UserLogin userLogin;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		UserLogin login= new UserLogin();
		
		if(login == null) {
			throw new UserPrincipalNotFoundException("User Not Found With User_Name"+username);
		}
       return new org.springframework.security.core.userdetails.UserDetails(login.getUser_Name(),login.getPassword(),new ArrayList<>());
		
	}

}
