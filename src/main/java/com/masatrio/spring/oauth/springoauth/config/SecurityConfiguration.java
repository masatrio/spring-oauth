package com.masatrio.spring.oauth.springoauth.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    // ensure the passwords are encoded properly
//		UserBuilder users = User.withDefaultPasswordEncoder();
//	    auth
//	    .inMemoryAuthentication()
//	            .withUser(users.username("aji")
//	            .password("aji")
//	            .roles("USER"));
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, status as enabled from s_users where username=?")
		.authoritiesByUsernameQuery("select u.username, p.user_role from s_users u inner join s_permissions p on u.id = p.id_user where u.username=?")
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/halo")
		.and()
		.logout();
	}
}
