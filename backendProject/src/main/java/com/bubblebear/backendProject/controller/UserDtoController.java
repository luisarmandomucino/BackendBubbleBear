package com.bubblebear.backendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubblebear.backendProject.dto.UserDto;
import com.bubblebear.backendProject.entity.User;
import com.bubblebear.backendProject.service.UserDtoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v2/users")
public class UserDtoController {
	@Autowired
	UserDtoService userDtoService;

	
	@PostMapping  //localhost:8080/api/v2/user
	public ResponseEntity<User> creatUserDto(@Validated @RequestBody User user) {
		User savedUser = userDtoService.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	
	@GetMapping("{id}")//localhost:8080/api/v2/user/2
	public ResponseEntity<UserDto> getUserDtoById(@PathVariable long id) { 
		UserDto userDto = userDtoService.getUserDtoById(id);
	return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsersDtos(){
		List<UserDto> user = userDtoService.getAllUsersDto(); 
		return new ResponseEntity<>(user, HttpStatus.OK);
	}


	 
	@PutMapping("{id}")//localhost:8080/api/v2/user/6
	public ResponseEntity<User> updateUser(@RequestBody @Validated User user, @PathVariable long id) {
		User updatedUser = userDtoService.updateUserDto(user, id);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	

	
	@DeleteMapping("{id}") //localhost:8080/api/v2/user/9
	public ResponseEntity<String> deleteUserDto(@PathVariable long id) {
		userDtoService.deleteUserDto(id);
		return new ResponseEntity<>("User id " + id + " successfully deleted", HttpStatus.OK);
	}
}
