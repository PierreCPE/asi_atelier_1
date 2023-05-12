package com.atelier3.DTO;

public class UserDTO {
	private String userName;
	private String surname;
	private String password;
	
	public UserDTO() {	
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", surname=" + surname + ", password=" + password + "]";
	}
}

