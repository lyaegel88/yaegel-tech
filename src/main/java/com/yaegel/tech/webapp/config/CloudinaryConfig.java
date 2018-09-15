package com.yaegel.tech.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
@ComponentScan("com.yaegel.tech.webapp")
public class CloudinaryConfig {

	@Bean
	public Cloudinary getCloudindary() {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "hitfox6pi",
				  "api_key", "939334414551673",
				  "api_secret", "BTyM6j7y3SFNCnMvZDj8obSzP10"));
		
		return cloudinary;
	}
	
}
