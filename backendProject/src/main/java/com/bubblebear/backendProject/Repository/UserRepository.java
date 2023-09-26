package com.bubblebear.backendProject.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bubblebear.backendProject.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
		
	List<User> findAllById(long id);
	User findById(long id);
	User getUserById(long id);
		


}
