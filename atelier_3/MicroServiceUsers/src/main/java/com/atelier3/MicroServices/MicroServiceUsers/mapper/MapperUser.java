package com.atelier3.MicroServices.MicroServiceUsers.mapper;

import com.atelier3.MicroServices.MicroServiceUsers.model.User;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserDTO;
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
	
	public static UserDTO userToDTO(User user) {
	    UserDTO userDTO = new UserDTO();
	    userDTO.setId(user.getId());
	    userDTO.setUserName(user.getUsername());
	    userDTO.setSurname(user.getSurname());
	    userDTO.setSolde(user.getSolde());
	    return userDTO;
	}
	
	public static User userDTOToUser(UserDTO userDTO) {
	    User user = new User();
	    user.setId(userDTO.getId());
	    user.setUsername(userDTO.getUserName());
	    user.setSurname(userDTO.getSurname());
	    user.setSolde(userDTO.getSolde());
	    return user;
	}

	
}
