package com.bubblebear.backendProject.security.jwt;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Data;
@CrossOrigin(origins = "*")
@Data
public class AuthCredentials {
	public String email;
	public String password;
	
}
