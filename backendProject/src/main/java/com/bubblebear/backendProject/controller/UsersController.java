package com.bubblebear.backendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.bubblebear.backendProject.Repository.UsersRepository;
import com.bubblebear.backendProject.entity.Users;

@Controller
@RequestMapping("api/users")
public class UsersController {

	@Autowired
	UsersRepository usersRepository;
	
	@PostMapping  
	public ResponseEntity<Users> creatUser(@Validated @RequestBody Users usersDto) {
		Users savedUsers = usersRepository.save(usersDto);
		return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Users> getUserById(@PathVariable long id) { 
	    Users user = usersRepository.findById(id); 
	    if (user != null) {
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users> users = (List<Users>) usersRepository.findAll(); 
		return ResponseEntity.ok(users);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Users> updateUser(@PathVariable long id, @Validated @RequestBody Users usersDto) {
		Users updateUsers = usersRepository.save(usersDto);
		return new ResponseEntity<>(updateUsers, HttpStatus.OK);
	}
	

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUsers(@PathVariable int id) {
		usersRepository.deleteById(id);
		return new ResponseEntity<>("User id " + id + " successfully deleted", HttpStatus.OK);
	}
	
}
