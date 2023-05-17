package com.sp.model;

public class ConnexionDTO {

	private String userName;
	private String password;
	
	public ConnexionDTO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return this.password;
	}

}
