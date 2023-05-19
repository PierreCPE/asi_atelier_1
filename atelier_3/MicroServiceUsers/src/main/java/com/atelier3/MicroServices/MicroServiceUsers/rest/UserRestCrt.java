package com.atelier3.MicroServices.MicroServiceUsers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atelier3.MicroServices.MicroServiceUsers.model.User;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserRegisterDTO;
import com.atelier3.MicroServices.MicroServiceUsers.service.UserService;





public class UserRestCrt {

	@Autowired
	UserService uService;
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public void register(@RequestBody UserRegisterDTO userRegisterDTO) {
		uService.addUser(userRegisterDTO);
	}
	
	@GetMapping(value = {"/user/{id}"})
	public User getUser(@PathVariable int id) {
		return uService.getUser(id);
	}
	
}
