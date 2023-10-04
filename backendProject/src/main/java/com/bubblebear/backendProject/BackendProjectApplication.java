package com.bubblebear.backendProject;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendProjectApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(BackendProjectApplication.class, args);
		
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedOrigins("http://localhost:5500")
				.allowedMethods( "GET", "POST", "PUT", "DELETE")
				.allowedHeaders("Authorization","Content-Type");
			}
		};
	}
	
}
