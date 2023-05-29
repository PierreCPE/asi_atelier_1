package com.atelier3.MicroServices.MicroServiceUsers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atelier3.MicroServices.MicroServiceUsers.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
	
	public List<Users> findByUsernameAndPassword(String username, String password);
	public List<Users> findBySurnameAndPassword(String surname, String password);
	
}
