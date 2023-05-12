package com.sp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sp.model.Auth;

public interface AuthRepository extends CrudRepository<Auth, Integer> {

	public Optional<Auth> findByUserName(String name);
	public Optional<Auth> findById(Integer id);
	public Optional<Auth> findBySurname(String surname);

}

