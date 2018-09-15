package com.yaegel.tech.webapp.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
	    .passwordEncoder(passwordEncoder())
		.usersByUsernameQuery(
			"select CustomerID, CustomerPassword, CustomerEnabled from customer where CustomerID=?")
		.authoritiesByUsernameQuery(
			"select CustomerID, CustomerRole from customer where CustomerID=?");
	}	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
			httpSecurity.formLogin().loginPage("/login")
			.usernameParameter("userId")
			.passwordParameter("password");
			httpSecurity.formLogin().defaultSuccessUrl
			("/members?page=1")
			.failureUrl("/login?error");
			httpSecurity.logout().logoutSuccessUrl("/login?logout");
			httpSecurity.exceptionHandling().accessDeniedPage("/login?accessDenied");
			httpSecurity.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/members/**").hasRole("ADMIN");
			httpSecurity.csrf().disable();
			}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}