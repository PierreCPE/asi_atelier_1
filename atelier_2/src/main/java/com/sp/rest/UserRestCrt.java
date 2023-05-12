package com.sp.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sp.model.User;
import com.sp.model.UserDTORegister;
import com.sp.service.UserService;
import com.sp.service.LoginService;

@Controller
public class UserRestCrt {
	@Autowired
	UserService uService;
	@Autowired
	LoginService lService;
	
	
  	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
  	public String index() {
  	    return "index.html";
  	
  	}	
	
	
	@RequestMapping(method=RequestMethod.POST,value="/user") //Lors de la connexion prend la méthode post avec les valeurs
	public void addUser(@RequestBody UserDTORegister user) {
		uService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/user/{id}")
	public User getUser(@PathVariable String id) {
		System.out.println(id);
		User u=uService.getUser(Integer.valueOf(id));
		return u;
	}
	
	@GetMapping("/register") //Le getmapping donne par défaut la requestmethod.get
    public String register(Model model) {
//		UserDTORegister DTOuser = new UserDTORegister();
//    	model.addAttribute("DTOuser", DTOuser);
    	return "register.html";
    }
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public void register(@RequestBody UserDTORegister DTOuser) {
		uService.addUser(DTOuser);
	}
	
	@GetMapping("/login") //Le getmapping donne par défaut la requestmethod.get
    public String login() {
    	return "login.html";
    }
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public ResponseEntity<Integer> login(@RequestBody UserDTORegister userdto) {
		int result = lService.checklogin(userdto);
		System.out.println(result);
	    return ResponseEntity.ok(result);
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
	
	@GetMapping("/home") //Le getmapping donne par défaut la requestmethod.get
    public String home() {
    	return "home.html";
    }

}
