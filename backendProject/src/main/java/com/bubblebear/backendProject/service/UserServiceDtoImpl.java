package com.bubblebear.backendProject.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubblebear.backendProject.dto.UserDto;
import com.bubblebear.backendProject.entity.*;


@Service
public class UserServiceDtoImpl implements UserDtoService {
	
	@Autowired
	UserService userService;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public UserDto createUserDto(UserDto userDto) {
		User userMapper = userDtoToUser(userDto);
		User newUser = userService.createUser(userMapper);
		return userToUserDto(newUser);
	}
	
	public UserDto userToUserDto(User newUser) {
		UserDto userDto = modelMapper.map(newUser, UserDto.class);
		return userDto;
	}

	public User userDtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}

	@Override
	public UserDto getUserDtoById(long id) {
		User existingUser = userService.getUserById(id);
		return userToUserDto(existingUser);
	}
	
	@Override
	public UserDto getUserDtoByEmail(String email) {
		User existingUser = userService.getUserByEmail(email);
		return userToUserDto(existingUser);
	}
	
	@Override
	public List<UserDto> getAllUsersDto() {
		List<User> users = userService.getAllUsers();
		return usersToUsersFto(users);
	}
	public List<UserDto> usersToUsersFto(List<User> users) {
		return users.stream().map(user -> userToUserDto(user)).toList();
	}

	@Override
	public UserDto updateUserDto(UserDto user, long id) {
			User existingUser = userService.getUserById(id);
			existingUser.setFullname(user.getFullname());
			existingUser.setEmail(user.getEmail());
			existingUser.setBirthday(user.getBirthday());
			existingUser.setPhone_number(user.getPhone_number());
		return userToUserDto( userService.createUser(existingUser));
	}
	
	@Override
	public void deleteUserDto(Long id) {
		userService.deleteUser(id);
	}
	

	
	


	

}
