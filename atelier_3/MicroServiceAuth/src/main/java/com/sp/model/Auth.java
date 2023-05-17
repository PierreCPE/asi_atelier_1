package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Auth  {
	@Id
	@GeneratedValue
	private Integer id;
	private String userName;
	private String surname;
	private String password;
	private int solde;


	public Auth(String userName, String surname, String password) {
		super();
		this.userName = userName;
		this.surname = surname;
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
		return "User [id=" + id + ", userName=" + userName + ", password=" + password
				+ ", solde=" + solde + "]";
	}
	

}
