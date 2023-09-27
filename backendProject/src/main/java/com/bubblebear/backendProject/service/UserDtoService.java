package com.bubblebear.backendProject.service;

import java.util.List;

import com.bubblebear.backendProject.dto.UserDto;

import com.bubblebear.backendProject.entity.limits.UserFieldLimits;

public interface UserDtoService extends UserFieldLimits{
	
	UserDto createUserDto(UserDto userDto);

	UserDto getUserDtoById(long id);
	
	UserDto getUserDtoByEmail(String email);
	
	
	List<UserDto> getAllUsersDto();


	UserDto updateUserDto(UserDto userDto, long id);



	void deleteUserDto(Long id);



	

}
