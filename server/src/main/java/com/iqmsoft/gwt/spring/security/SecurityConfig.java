package com.iqmsoft.gwt.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableJpaRepositories(basePackages = "com.iqmsoft.gwt.spring.security.repos")
@ComponentScan(basePackages = "com.iqmsoft.gwt.spring.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Autowired
	private UserDetailsService users;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(users).getUserDetailsService().loadUserByUsername("admin");
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()
		.antMatchers("/GwtSpringSecurity.html", "/GwtSpringSecurity/**", "/user").authenticated()
		.and().formLogin().defaultSuccessUrl("/GwtSpringSecurity.html")
		.and()
		.logout().logoutUrl("/logout").logoutSuccessUrl("/login")
		.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}

}
