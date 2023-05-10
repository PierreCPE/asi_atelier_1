package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User  {
	@Id
	@GeneratedValue
	private Integer id;
	private String userName;
	private String mail;
	private String password;
	private int solde;

	public User() {	
	}

	public User(String userName, String mail, String password) {
		super();
		this.userName = userName;
		this.mail = mail;
		this.password = password;
	}

  // GETTER AND SETTER
	
	public Integer getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;	
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getSolde() {
		return solde;
	}
	
	public void setSolde(int solde) {
		this.solde = solde;
	}
	
	@Override
	public String toString() {
		return "Utilisateur :"+this.userName+" Email : "+this.mail+" Mdp: "+this.password;
	}
	

}
