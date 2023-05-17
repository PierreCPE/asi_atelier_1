package com.sp.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sp.model.ConnexionDTO;
import com.sp.service.AuthService;




@RestController
public class AuthRestCrt {
    @Autowired
    AuthService aservice;
    
	@GetMapping("/checkLogin") //Le getmapping donne par défaut la requestmethod.get
	public Optional <userDTO> checkLogin(@RequestBody ConnexionDTO coDTO) {
		aservice.checkLogin(coDTO);
		return userDTO;
	
    }
	
	
}