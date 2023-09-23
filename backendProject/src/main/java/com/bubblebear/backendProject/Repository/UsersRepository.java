package com.bubblebear.backendProject.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bubblebear.backendProject.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {
		
		List<Users> findByFullName(String fullName);
		
		Users findById(long id);
	
}
