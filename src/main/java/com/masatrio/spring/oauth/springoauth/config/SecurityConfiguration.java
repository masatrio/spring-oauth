package com.masatrio.spring.oauth.springoauth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    // ensure the passwords are encoded properly
		UserBuilder users = User.withDefaultPasswordEncoder();
	    auth
	    .inMemoryAuthentication()
	            .withUser(users.username("aji")
	            .password("aji")
	            .roles("USER"));
	}
}
