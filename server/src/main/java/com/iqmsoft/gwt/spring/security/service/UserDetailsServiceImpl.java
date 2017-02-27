package com.iqmsoft.gwt.spring.security.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iqmsoft.gwt.spring.security.model.MyUser;
import com.iqmsoft.gwt.spring.security.model.MyUserDetails;
import com.iqmsoft.gwt.spring.security.repos.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

   @Autowired
   private UserRepository u;
   
   @Autowired
   private AuthenticationManager authenticationManager;

   
   public void authenticate(String username, String password){
	    try{
	        User user = new User(username, password, null);
	        Authentication request = 
	        		new UsernamePasswordAuthenticationToken(user, password);
	        Authentication result = authenticationManager.authenticate(request);
	        SecurityContextHolder.getContext().setAuthentication(result);       
	    } catch (InternalAuthenticationServiceException e){
	        
	    }
	}
   
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	 
	  MyUser u1 = u.findByUsername(username);
     
	  MyUserDetails d = new MyUserDetails();
	  
	  d.setUsername(u1.getUsername());
	  d.setPassword(u1.getPassword());
	  
	  return d;
   }

}
