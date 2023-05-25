package com.atelier3.MicroServices.MicroServiceUsers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atelier3.MicroServices.MicroServiceUsers.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public List<User> findByUsernameAndPassword(String username, String password);
	public List<User> findBySurnameAndPassword(String surname, String password);
	
}
