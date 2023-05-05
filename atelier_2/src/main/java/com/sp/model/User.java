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
	

	public User() {	
	}

	public User(int id,String userName, String mail, String password) {
		super();
		this.id=id;
		this.userName = userName;
		this.mail = mail;
		this.password = password;
	}

  // GETTER AND SETTER
	
	public int getId() {
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
	
	@Override
	public String toString() {
		return "Utilisateur :"+this.userName+" Email : "+this.mail+" Mdp: "+this.password;
	}
	

}
