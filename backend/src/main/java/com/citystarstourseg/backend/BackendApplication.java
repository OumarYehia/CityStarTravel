package com.citystarstourseg.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@CrossOrigin(origins = "*")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}


	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry)  {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "DELETE", "PUT");
			}
		};
	}
}
