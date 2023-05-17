package com.sp.model;

public class UserDTO  {
	private Integer id;
	private String userName;
	private String surname;
	private int solde;

	public UserDTO() {	
	}

  // GETTER AND SETTER
	
	public Integer getId() {
		return id;
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
		return "User [id=" + id + ", userName=" + userName + ", surname=" + surname + ", solde=" + solde + "]";
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
	

}
