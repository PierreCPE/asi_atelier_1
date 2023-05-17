package com.atelier3.MicroServices.MicroServiceUsers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.atelier3.MicroServices.MicroServiceUsers.model.User;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserRegisterDTO;
import com.atelier3.MicroServices.MicroServiceUsers.repository.UserRepository;

public class UserService {
	
	@Autowired
	UserRepository uRepo;
	
	public boolean addUser(UserRegisterDTO userDTO) {
		
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		List<User> existant_users = uRepo.findByUsernameAndPassword(username, password)
		//TODO
		if (!uOpt.isPresent()) {
			User u = MapperUser.UserDTORegisterToUser(userDTO);
			uRepository.save(u);
			System.out.println(u);
			
			attributeCard(u.getId());
			
			return true;
		}
		else {
			return false;	
		}
		
	}

}
