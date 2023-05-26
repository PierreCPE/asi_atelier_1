package com.atelier3.MicroServices.MicroServiceUsers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atelier3.MicroServices.MicroServiceUsers.mapper.MapperUser;
import com.atelier3.MicroServices.MicroServiceUsers.model.ConnexionDTO;
import com.atelier3.MicroServices.MicroServiceUsers.model.Users;
import com.atelier3.MicroServices.MicroServiceUsers.model.UserRegisterDTO;
import com.atelier3.MicroServices.MicroServiceUsers.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository uRepo;

	
	/**
	 * Inscrit un utilisateur à la base de données
	 * Demande à CardService de lui attriuber ses cartes
	 * @param userRegisterDTO
	 * @return true si l'utilisateur a pu être créer, false sinon
	 */			
	public boolean addUser(UserRegisterDTO userRegisterDTO) {
		String username = userRegisterDTO.getUsername();
		String password = userRegisterDTO.getPassword();
		List<Users> existant_users = uRepo.findByUsernameAndPassword(username, password);
		if (existant_users.isEmpty()) {
			Users u = MapperUser.UserRegisterDTOtoUser(userRegisterDTO);
			uRepo.save(u);
			this.distributeCards(u.getId());
			return true;
		}
		else {
			return false;
		}
	}

	private void distributeCards(Integer id) {
		RestTemplate restTemplate = new RestTemplate();
		String URL_DISTRIBUTION = "http://microservice-cards/distribute";
		String url = URL_DISTRIBUTION + "?userId=" + id;
	    restTemplate.exchange(url, HttpMethod.GET, null, Void.class);
	}

	public Users getUser(int id) {
		Optional<Users> u0pt = uRepo.findById(id);
		if (u0pt.isPresent()) {
			return u0pt.get();
		}
		else {
			return null;
		}
	}
	
	public void updateUser(Users u) {
		uRepo.save(u);
	}

	public int check(ConnexionDTO connexiondto) {
		List<Users> uList = uRepo.findBySurnameAndPassword(connexiondto.getSurname(), connexiondto.getPassword());
		if (uList.isEmpty()) {
			return -1;
		}
		else {
			System.out.println("User trouvé");
			return uList.get(0).getId();
		}
	}
	

}
