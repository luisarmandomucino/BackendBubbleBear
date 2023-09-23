package com.bubblebear.backendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.bubblebear.backendProject.Repository.UsersRepository;
import com.bubblebear.backendProject.entity.Users;



@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersRepository usersRepository;
	
	
	@GetMapping
	public List<Users> getAllUsers(){
		log.info("Solicitud para usuarios");
		List<Users> users = (List<Users>) usersRepository.findAll();
		return users;
	}
	
	@PostMapping  
	public Users setUsers(@RequestBody Users users) {
		log.info("Solicitud post, agregar nuevo cliente");
		Users.setId(null);
		Users newUsers = usersRepository.save(users);
		return newUsers;
	}

	
	
	
	
}
