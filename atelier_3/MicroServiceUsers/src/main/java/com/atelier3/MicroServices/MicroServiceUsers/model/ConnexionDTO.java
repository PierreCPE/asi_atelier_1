package com.atelier3.MicroServices.MicroServiceUsers.model;

public class ConnexionDTO {

	private String surname;
	private String password;
	
	public ConnexionDTO(String surname, String password) {
		this.surname = surname;
		this.password = password;
	}
	
	public String getSurname() {
		return surname;
	}

	public String getPassword() {
		return this.password;
	}

}
