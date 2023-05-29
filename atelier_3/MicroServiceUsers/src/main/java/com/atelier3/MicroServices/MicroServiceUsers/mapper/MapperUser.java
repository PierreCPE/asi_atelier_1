package com.atelier3.MicroServices.MicroServiceUsers.mapper;

import com.atelier3.MicroServices.MicroServiceUsers.model.Users;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserRegisterDTO;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserDTO;

public class MapperUser {

	public static Users userRegisterDTOtoUser(UserRegisterDTO userRegisterDTO) {
		Users user = new Users();
		user.setSurname(userRegisterDTO.getSurname());
		user.setUsername(userRegisterDTO.getUsername());
		user.setPassword(userRegisterDTO.getPassword());
		user.setSolde(0);
		return user;
	}
	
	public static UserDTO userToDTO(Users user) {
	    UserDTO userDTO = new UserDTO();
	    userDTO.setUserName(user.getUsername());
	    userDTO.setSurname(user.getSurname());
	    userDTO.setSolde(user.getSolde());
	    return userDTO;
	}
	
	public static Users userDTOToUser(UserDTO userDTO) {
	    Users user = new Users();
	    user.setId(userDTO.getId());
	    user.setUsername(userDTO.getUserName());
	    user.setSurname(userDTO.getSurname());
	    user.setSolde(userDTO.getSolde());
	    return user;
	}

	
}
