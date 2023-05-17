package com.sp.model;

public class AuthDTO {
	
	private Integer id;
	private String userName;
	private String surname;
	private int solde;
	//private String password; On veut pas rendre le password a l'utilisateur
	
	public AuthDTO(String userName, String surname, int solde)  {
		this.userName = userName;
		this.surname = surname;
		this.solde = solde;
	}
	// Nos getteurs
	
	public Integer getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getSurname() {
		return this.surname;
	}

	public int getSolde() {
		return solde;
	}

	@Override
	public String toString() {
		return "AuthDTO [userName=" + userName + ", surname=" + surname + "]";
	}
	
}
