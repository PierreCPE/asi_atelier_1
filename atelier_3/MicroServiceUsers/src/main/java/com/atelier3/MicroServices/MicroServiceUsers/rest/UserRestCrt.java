package com.atelier3.MicroServices.MicroServiceUsers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.atelier3.MicroServices.MicroServiceUsers.mapper.MapperUser;
import com.atelier3.MicroServices.MicroServiceUsers.model.ConnexionDTO;
import com.atelier3.MicroServices.MicroServiceUsers.model.Users;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserRegisterDTO;
import com.atelier3.MicroServices.MicroServiceUsers.service.UsersService;
import com.sp.model.UserDTO;





public class UserRestCrt {

	@Autowired
	UsersService uService;
	
	@PostMapping(value = {"/register"})
	public boolean register(@RequestBody UserRegisterDTO userRegisterDTO) {
		return uService.addUser(userRegisterDTO);
	}
	
	/**
	 * Renvoie true si le surname et mdp renseignés correspondent à la BDD
	 * @param connexiondto
	 * @return boolean
	 */
	@PostMapping(value = {"/users"})
	public int checklogin(@RequestBody ConnexionDTO connexiondto) {
		return uService.check(connexiondto);
	}
	
	@GetMapping(value = {"/user/{id}"})
	public UserDTO getUser(@PathVariable int id) {
		Users u = uService.getUser(id);
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
		Users existingUser = uService.getUser(updatedUserDTO.getId());
		if (existingUser != null) {
			existingUser.setUsername(updatedUserDTO.getUserName());
			existingUser.setSurname(updatedUserDTO.getSurname());
			existingUser.setSolde(updatedUserDTO.getSolde());
	        uService.updateUser(existingUser);
		}
    }
	
}
