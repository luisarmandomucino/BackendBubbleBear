package com.bubblebear.backendProject.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubblebear.backendProject.Repository.UserRepository;
import com.bubblebear.backendProject.entity.User;


@Service 
public class UserServiceImpl implements UserService {
	
	@Autowired 
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return saveUser(user); 
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers() { 
		return userRepository.findAll();
	}
	
	@Override 
	public User getUserById(long id) {
		return userRepository.findById(id);
	}

	@Override 
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override 
	public User updateUser(User user, long id) {
		User existingUser = userRepository.findById(id);
		existingUser.setFullname(user.getFullname());
		existingUser.setEmail(user.getEmail());
		existingUser.setBirthday(user.getBirthday());
		existingUser.setPhone_number(user.getPhone_number());
		return saveUser(existingUser);
	}
	
	@Override 
	public void deleteUser(Long id) {
		User existingUser = userRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("User does not exist with id "+ id) );
		userRepository.delete(existingUser);
	}
	
}
