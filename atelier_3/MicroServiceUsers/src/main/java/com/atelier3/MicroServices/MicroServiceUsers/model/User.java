package com.atelier3.MicroServices.MicroServiceUsers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User  {
	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String surname;
	private String password;
	private int solde;

	public User() {	
	}

  // GETTER AND SETTER
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;	
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
	
	public int getSolde() {
		return solde;
	}
	
	public void setSolde(int solde) {
		this.solde = solde;
	}
	
	public void debit(int prix) {
		if (this.getSolde()>=prix) {
			this.setSolde(this.getSolde()-prix);
		}
	}
	
	public void credit(int prix) {
		this.setSolde(this.getSolde()+prix);
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + username + ", surname=" + surname + ", password=" + password
				+ ", solde=" + solde + "]";
	}
	

}
