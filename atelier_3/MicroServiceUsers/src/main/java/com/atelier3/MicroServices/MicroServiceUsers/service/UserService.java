package com.atelier3.MicroServices.MicroServiceUsers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.atelier3.MicroServices.MicroServiceUsers.mapper.MapperUser;
import com.atelier3.MicroServices.MicroServiceUsers.model.ConnexionDTO;
import com.atelier3.MicroServices.MicroServiceUsers.model.User;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserRegisterDTO;
import com.atelier3.MicroServices.MicroServiceUsers.repository.UserRepository;

public class UserService {
	
	@Autowired
	UserRepository uRepo;
	
	String URL_DISTRIBUTION = "http://microservice-cards/distribute";
	
	private final RestTemplate restTemplate;

	public UserService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	/**
	 * Inscrit un utilisateur à la base de données
	 * Demande à CardService de lui attriuber ses cartes
	 * @param userRegisterDTO
	 * @return true si l'utilisateur a pu être créer, false sinon
	 */			
	public boolean addUser(UserRegisterDTO userRegisterDTO) {
		String username = userRegisterDTO.getUsername();
		String password = userRegisterDTO.getPassword();
		List<User> existant_users = uRepo.findByUsernameAndPassword(username, password);
		if (existant_users.isEmpty()) {
			User u = MapperUser.UserRegisterDTOtoUser(userRegisterDTO);
			uRepo.save(u);
			this.distributeCards(u.getId());
			return true;
		}
		else {
			return false;
		}
	}

	private void distributeCards(Integer id) {
		String url = URL_DISTRIBUTION + "?userId=" + id;
	    restTemplate.exchange(url, HttpMethod.GET, null, Void.class);
	}

	public User getUser(int id) {
		Optional<User> u0pt = uRepo.findById(id);
		if (u0pt.isPresent()) {
			return u0pt.get();
		}
		else {
			return null;
		}
	}
	
	public void updateUser(User u) {
		uRepo.save(u);
	}

	public int check(ConnexionDTO connexiondto) {
		List<User> uList = uRepo.findBySurnameAndPassword(connexiondto.getSurname(), connexiondto.getPassword());
		if (uList.isEmpty()) {
			return -1;
		}
		else {
			System.out.println("User trouvé");
			return uList.get(0).getId();
		}
	}
	

}
