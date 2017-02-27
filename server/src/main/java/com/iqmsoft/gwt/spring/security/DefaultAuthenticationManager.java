package com.iqmsoft.gwt.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
class DefaultAuthenticationManager implements AuthenticationManager {

	@Autowired
	private UserDetailsService usersService;

	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		UserDetails user = usersService.loadUserByUsername(((User)auth.getPrincipal()).getUsername());
		if (user != null) {
			return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
		}
	
		return auth;
	}

}