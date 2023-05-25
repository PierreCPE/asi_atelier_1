package com.atelier3.MicroServices.MicroServiceUsers.model;


public class UserDTO  {
	private Integer id;
	private String userName;
	private String surname;
	private int solde;

	public UserDTO() {	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSolde() {
		return solde;
	}

	public void setSolde(int solde) {
		this.solde = solde;
	}
}
