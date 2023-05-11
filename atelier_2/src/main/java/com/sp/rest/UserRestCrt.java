package com.sp.rest;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.model.UserDTORegister;
import com.sp.service.UserService;
import com.sp.service.LoginService;

@RestController
public class UserRestCrt {
	@Autowired
	UserService uService;
	@Autowired
	LoginService lService;
	@Autowired
	private HttpSession session;
	
	@RequestMapping(method=RequestMethod.POST,value="/user") //Lors de la connexion prend la méthode post avec les valeurs
	public void addUser(@RequestBody UserDTORegister user) {
		uService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/{id}")
	public User getUser(@PathVariable String id) {
		User u=uService.getUser(Integer.valueOf(id));
		return u;
	}
	
	@GetMapping("/") //Le getmapping donne par défaut la requestmethod.get
	public String readCookie(@CookieValue(value = "id", defaultValue = "0") String retId) {
	    return "Hey! My id is " + retId;
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public void register(@RequestBody UserDTORegister DTOuser) {
//		System.out.println(uService.addUser(DTOuser));
		uService.addUser(DTOuser);
	}
	
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public int login(@RequestBody UserDTORegister userdto) {
//		System.out.println(lService.checklogin(userdto));
	    return lService.checklogin(userdto);
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="/login")
//	public int verifLogin(@RequestBody User user) {
//		try {
//			User usr = authRestService.getLogs(user.getSurname(), user.getPassword());
//			//System.out.println(usr.getId());
//			return usr.getId();
//		} catch (FonctionalException e) {
//			 e.printStackTrace(); 
//			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getMessage());
//			
//		}
//	}
	
//	@RequestMapping(method=RequestMethod.GET,value="/home")
//	public String home(HttpSession session, HttpServletResponse response) throws IOException {
//	    if (session.getAttribute("connected") == null) {
//	        response.sendRedirect("/login.html");
//	        return null;
//	    }
//	    response.sendRedirect("/home.html");
//	    return null;
//	}

}
