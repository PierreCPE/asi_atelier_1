package com.sp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.sp.model.Hero;

public interface UserRepository extends CrudRepository<User, Integer> {

	public List<Hero> findByName(String name);
}

