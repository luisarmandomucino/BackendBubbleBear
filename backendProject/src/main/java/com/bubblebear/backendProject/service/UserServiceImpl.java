package com.bubblebear.backendProject.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubblebear.backendProject.Repository.UserRepository;
import com.bubblebear.backendProject.entity.User;


@Service // componente servicio--logica negocio
public class UserServiceImpl implements UserService {
	
	@Autowired //inyeccion para manipular datos del repository
	UserRepository userRepository;
	
	
	@Override
	public User createUser(User user) {//el metodo recibe como parametro al usuario
		return saveUser(user); //lama al segundo metodo
	}

	public User saveUser(User user) {//este metodo recibe el parametro del usuario
		return userRepository.save(user);//guarda el nuevo usuario en el userRepository
	}
	
		@Override//trae todos los usuarios
	public List<User> getAllUsers() { 
		return (List<User>) userRepository.findAll();
	}
	
	
	@Override //busca usuarios por id
	public User getUserById(long id) {
		return userRepository.findById(id);

	}
	
	/*
	@Override // Anneth
	public User getUserById(long id) {
		return userRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("User does not exist with id "+ id) );
	
	}
	*/
	
	//metodo para buscarlo por email, para el login
	@Override 
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	
	@Override //modifica datos
	public User updateUser(User user, long id) {
		
		User existingUser = userRepository.findById(id);
		
		existingUser.setFullname(user.getFullname());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setBirthday(user.getBirthday());
		existingUser.setPhone_number(user.getPhone_number());
		
		return saveUser(existingUser);
	}
	
	@Override //elimina el usuario
	public void deleteUser(Long id) {
		User existingUser = userRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("User does not exist with id "+ id) );
		userRepository.delete(existingUser);
	}
	
	
}
