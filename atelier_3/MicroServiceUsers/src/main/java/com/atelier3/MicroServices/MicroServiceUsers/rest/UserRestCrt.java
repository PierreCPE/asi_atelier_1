package com.atelier3.MicroServices.MicroServiceUsers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atelier3.MicroServices.MicroServiceUsers.mapper.MapperUser;
import com.atelier3.MicroServices.MicroServiceUsers.model.User;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserRegisterDTO;
import com.atelier3.MicroServices.MicroServiceUsers.service.UserService;
import com.sp.model.UserDTO;





public class UserRestCrt {

	@Autowired
	UserService uService;
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public void register(@RequestBody UserRegisterDTO userRegisterDTO) {
		uService.addUser(userRegisterDTO);
	}
	
	@GetMapping(value = {"/user/{id}"})
	public UserDTO getUser(@PathVariable int id) {
		User u = uService.getUser(id);
		if (u == null) {
			return null;
		}
		else {
			UserDTO userDTO = MapperUser.userToDTO(u);
			return userDTO;
		}
	}
	
	/**
	 * Met à jour l'user passé dans la requête HTML
	 * @param updatedCardDto
	 */
	@PutMapping("/users")
    public void updateCard(@RequestBody UserDTO updatedUserDTO) {
		User existingUser = uService.getUser(updatedUserDTO.getId());
		if (existingUser != null) {
			existingUser.setId(updatedUserDTO.getId());
			existingUser.setUsername(updatedUserDTO.getUserName());
			existingUser.setSurname(updatedUserDTO.getSurname());
			existingUser.setSolde(updatedUserDTO.getSolde());
	        uService.updateUser(existingUser);
		}
    }
	
}
