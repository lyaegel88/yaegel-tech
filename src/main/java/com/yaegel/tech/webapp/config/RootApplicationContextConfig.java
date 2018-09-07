package com.yaegel.tech.webapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
@ComponentScan("com.yaegel.tech.webapp")
@Profile("dev")
public class RootApplicationContextConfig {
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/store");
        dataSource.setUsername("ctuonline");
        dataSource.setPassword("student");
         
        return dataSource;
    }
	
	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate() {
	
		return new NamedParameterJdbcTemplate(getDataSource());
	}
	
	@Bean
	public Cloudinary getCloudinary() {
	
	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			  "cloud_name", "hitfox6pi",
			  "api_key", "939334414551673",
			  "api_secret", "BTyM6j7y3SFNCnMvZDj8obSzP10"));
	
	return cloudinary;
	}

}
