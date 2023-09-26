package com.bubblebear.backendProject.service;

import java.util.List;

import com.bubblebear.backendProject.entity.User;

public interface UserService {

	User createUser(User user); 

	User getUserById(long id);

	List<User> getAllUsers();

	User updateUser(User user, long id);

	User getUserByEmail(String email);

	void deleteUser(Long id);

}
