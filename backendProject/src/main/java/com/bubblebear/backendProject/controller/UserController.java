package com.bubblebear.backendProject.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.bubblebear.backendProject.repository.UserRepository;
import com.bubblebear.backendProject.entity.User;

@Controller
@RequestMapping("api/v1/user") //localhost:8080/api/v1/user
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("{id}")//localhost:8080/api/v1/user/2
	public ResponseEntity<User> getUserById(@PathVariable long id) { 
		   User user = userRepository.getUserById(id);
		   return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping //localhost:8080/api/v1/user
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = (List<User>) userRepository.findAll(); 
		return ResponseEntity.ok(users);
	}
	
	@PostMapping  //localhost:8080/api/v1/user
	public ResponseEntity<User> creatUser(@Validated @RequestBody User usersDto) {
		User savedUsers = userRepository.save(usersDto);
		return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
	}

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
	}
	 
	@DeleteMapping("{id}") //localhost:8080/api/v1/user/9
	public ResponseEntity<String> deleteUsers(@PathVariable long id) {
		userRepository.deleteById(id);
		return new ResponseEntity<>("User id " + id + " successfully deleted", HttpStatus.OK);
	}

}
