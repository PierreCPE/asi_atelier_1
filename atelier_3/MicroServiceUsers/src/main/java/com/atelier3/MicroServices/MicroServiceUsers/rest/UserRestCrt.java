package com.atelier3.MicroServices.MicroServiceUsers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atelier3.DTO.UserDTO;
import com.atelier3.MicroServices.MicroServiceUsers.service.UserService;





public class UserRestCrt {

	@Autowired
	UserService uService;
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public void register(@RequestBody UserDTO userDTO) {
		uService.addUser(userDTO);
	}
	
}
