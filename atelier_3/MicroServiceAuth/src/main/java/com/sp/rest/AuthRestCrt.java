package com.sp.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.ConnexionDTO;
import com.sp.model.UserRegisterDTO;
import com.sp.service.AuthService;




@RestController
public class AuthRestCrt {
    @Autowired
    AuthService aservice;
    
//	@GetMapping("/checkLogin") //Le getmapping donne par défaut la requestmethod.get
//	public Optional <userDTO> checkLogin(@RequestBody ConnexionDTO coDTO) {
//		aservice.checkLogin(coDTO);
//		return userDTO;
//	
//    }
	
    //RESTE A FAIRE LA GESTION DU LOGIN COTE CLIENT
    /**
     * Retourne l'id de l'user si la connexion a réussi, -1 sinon
     * @param connexiondto
     * @return int
     */
	@PostMapping(value = {"/login"})
	public int login(@RequestBody ConnexionDTO connexiondto) {
		return aservice.checklogin(connexiondto);
	}
	
    //RESTE A FAIRE LA GESTION DU REGISTER COTE CLIENT
	/**
	 * Retourne true si le register a réussi, false sinon
	 * @param userRegisterDTO
	 * @return boolean
	 */
	@PostMapping(value = {"/register"})
	public boolean register(@RequestBody UserRegisterDTO userRegisterDTO) {
		return aservice.register(userRegisterDTO);
	}
	
}