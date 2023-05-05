package com.sp.mapper;

import com.sp.model.User;
import com.sp.model.UserDTORegister;

public class MapperUser {
	
	public static User UserDTORegisterToUser(UserDTORegister userDTO) {
		User user = new User();
		user.setMail(userDTO.getMail());
		user.setUserName(userDTO.getUserName());
		user.setPassword(user.getPassword());
		user.setSolde(0);
		return user;
	}
	
}
