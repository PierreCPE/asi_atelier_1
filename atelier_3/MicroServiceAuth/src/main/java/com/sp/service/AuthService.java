package com.sp.service;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;


import com.sp.model.ConnexionDTO;

@Service
public class AuthService { // voir le site pour rendre en json le cookie

	private final RestTemplate restTemplate;
	static final String URL_USERS = "http://localhost:8081/users";
	
//	public userDTO checkLogin(ConnexionDTO coDTO) {
//		return userDTO;
//		}
//	}

	public AuthService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public int checklogin(ConnexionDTO connexiondto) {
		ResponseEntity<Integer> response = restTemplate.exchange(
		        URL_USERS,
		        HttpMethod.POST,
		        new HttpEntity<>(connexiondto),
		        Integer.class
		    );
		    
		    if (response.getStatusCode() == HttpStatus.OK) {
		        return response.getBody();
		    } else {
		        return -1;
		    }
	}
	
}
	