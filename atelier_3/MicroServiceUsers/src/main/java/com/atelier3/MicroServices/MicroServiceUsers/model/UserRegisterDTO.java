package com.atelier3.MicroServices.MicroServiceUsers.model;

public class UserRegisterDTO {
	
	private String username;
	private String surname;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public String getSurname() {
		return surname;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
