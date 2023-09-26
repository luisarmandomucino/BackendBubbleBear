package com.bubblebear.backendProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//import com.bubblebear.backendProject.Repository.UserRepository;
import com.bubblebear.backendProject.entity.User;
import com.bubblebear.backendProject.service.UserService;

@Controller
@RequestMapping("api/user") //localhost:8080/api/v1/user
public class UserController {

	@Autowired
	UserService userService;
//	UserRepository userRepository;
	
	/*
	@PostMapping  //localhost:8080/api/v1/user
	public ResponseEntity<User> creatUser(@Validated @RequestBody User userDto) {
		User savedUsers = userRepository.save(userDto);
		return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
	}*/
	
	@PostMapping  //localhost:8080/api/user
	public ResponseEntity<User> creatUser(@Validated @RequestBody User user) {
		User savedUsers = userService.createUser(user);
		return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
	}
	
	/*
	@GetMapping("{id}")//localhost:8080/api/v1/user/2
	public ResponseEntity<User> getUserById(@PathVariable long id) { 
		   User user = userRepository.getUserById(id);
		   return new ResponseEntity<>(user, HttpStatus.OK);
	}*/
	
	@GetMapping("{id}")//localhost:8080/api/user/2
	public ResponseEntity<User> getUserById(@PathVariable long id) { 
	User user = userService.getUserById(id);
	return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	/*
	@GetMapping //localhost:8080/api/v1/user
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = (List<User>) userRepository.findAll(); 
		return ResponseEntity.ok(users);
	}*/
	
	
	@GetMapping //localhost:8080/api/user
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers(); 
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	/*
	@PutMapping("{id}")//localhost:8080/api/v1/user/6
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id) {
		User existingUser = userRepository.findById(id);
		
		if(existingUser == null ) {
			return ResponseEntity.notFound().build();
		}
		
		existingUser.setFullname(user.getFullname());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setBirthday(user.getBirthday());
		existingUser.setPhone_number(user.getPhone_number());
		existingUser.setRole(user.getRole());
		
		User updatedUser = userRepository.save(existingUser);
		return ResponseEntity.ok(updatedUser);
	}*/
	 
	@PutMapping("{id}")//localhost:8080/api/user/6
	public ResponseEntity<User> updateUser(@RequestBody @Validated User user, @PathVariable long id) {
		User updatedUser = userService.updateUser(user, id);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	/*
	@DeleteMapping("{id}") //localhost:8080/api/v1/user/9
	public ResponseEntity<String> deleteUsers(@PathVariable long id) {
		userRepository.deleteById(id);
		return new ResponseEntity<>("User id " + id + " successfully deleted", HttpStatus.OK);
	}*/

	
	
	@DeleteMapping("{id}") //localhost:8080/api/user/9
	public ResponseEntity<String> deleteUsers(@PathVariable long id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User id " + id + " successfully deleted", HttpStatus.OK);
	}

}
