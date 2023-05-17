package com.atelier3.MicroServices.MicroServiceUsers.mapper;

import com.atelier3.MicroServices.MicroServiceUsers.model.User;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserRegisterDTO;

public class MapperUser {

	public static User UserRegisterDTOtoUser(UserRegisterDTO userRegisterDTO) {
		User user = new User();
		user.setSurname(userRegisterDTO.getSurname());
		user.setUsername(userRegisterDTO.getUsername());
		user.setPassword(userRegisterDTO.getPassword());
		user.setSolde(0);
		return user;
	}
	
}
