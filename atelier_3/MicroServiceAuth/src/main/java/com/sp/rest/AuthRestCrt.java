package com.sp.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sp.model.ConnexionDTO;
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
	
	@PostMapping(value = {"/login"})
	public int login(@RequestBody ConnexionDTO connexiondto) {
		return aservice.checklogin(connexiondto);
	}
	
	
}