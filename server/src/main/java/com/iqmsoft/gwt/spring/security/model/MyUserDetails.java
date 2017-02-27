package com.iqmsoft.gwt.spring.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private String username;
	
    public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	
    
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return null;
	}

	public String getPassword() {
		
		return password;
	}

	public String getUsername() {
	
		return username;
	}

	public boolean isAccountNonExpired() {
		
		return true;
	}

	public boolean isAccountNonLocked() {
		
		return true;
	}

	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	public boolean isEnabled() {
		
		return true;
	}

}
