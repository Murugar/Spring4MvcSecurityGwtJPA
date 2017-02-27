package com.iqmsoft.gwt.spring.security;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iqmsoft.gwt.spring.security.model.MyUser;
import com.iqmsoft.gwt.spring.security.service.UserDetailsServiceImpl;

@Controller
public class AppController {
	
	@Autowired
	private UserDetailsServiceImpl usersService;
	
	@RequestMapping("/user")
	public ResponseEntity<String> user(@AuthenticationPrincipal UserDetails user) {

		return new ResponseEntity<String>(user.getUsername() + " , " +  user.getPassword(), HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<MyUser> login(@RequestBody MyUser user) {
		try {
			usersService.authenticate(user.getUsername(), user.getPassword());
			return new ResponseEntity<MyUser>(user, HttpStatus.OK);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<MyUser>(HttpStatus.UNAUTHORIZED);
		}
	}
}
