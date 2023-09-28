package com.bubblebear.backendProject.service;

import java.util.List;

import com.bubblebear.backendProject.dto.UserDto;
import com.bubblebear.backendProject.entity.User;
import com.bubblebear.backendProject.entity.limits.UserFieldLimits;

public interface UserDtoService extends UserFieldLimits{
	

	UserDto getUserDtoById(long id);
	
	UserDto getUserDtoByEmail(String email);
	
	List<UserDto> getAllUsersDto();

	User updateUserDto(User user, long id);

	void deleteUserDto(Long id);

	User createUser(User user);

}
