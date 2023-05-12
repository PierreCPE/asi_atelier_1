package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.mapper.MapperUser;
import com.sp.model.User;
import com.sp.model.UserDTORegister;
import com.sp.repository.UserRepository;


@Service
public class LoginService { // voir le site pour rendre en json le cookie
	@Autowired
	UserRepository uRepository;

//	public User getUser(int id) {
//		return null;
//	}
	
	public int checklogin(UserDTORegister userdto) {
		Optional<User> uOpt =uRepository.findBySurname(MapperUser.UserDTORegisterToUser(userdto).getSurname());
		if (uOpt.isPresent()) {
			System.out.println(userdto.getPassword());
			System.out.println(uOpt.get().getPassword());
			if (userdto.getPassword().equals(uOpt.get().getPassword())) {
				System.out.println("rentre if");
				return uOpt.get().getId();
			}
			return -1;
		}
		return -1;
	}
}