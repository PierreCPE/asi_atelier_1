package com.atelier3.MicroServices.MicroServiceUsers.repository;

import org.springframework.data.repository.CrudRepository;

import com.atelier3.MicroServices.MicroServiceUsers.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
}
