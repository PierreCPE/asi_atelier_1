package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;
import com.sp.model.UserDTORegister;
import com.sp.repository.UserRepository;


@Service
public class LoginService { // voir le site pour rendre en json le cookie
	@Autowired
	UserRepository uRepository;

	public User getUser(int id) {
		return null;
	}
	
	public boolean checklogin(UserDTORegister userdto) {
		Optional<User> uOpt =uRepository.findByUserName(userdto.getUserName());
		if ((uOpt.isPresent()) && (userdto.getPassword() == uOpt.get().getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
}