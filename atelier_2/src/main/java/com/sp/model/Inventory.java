package com.sp.model;

import javax.persistence.Entity;


@Entity
public class Inventory  {
	private int iduser;
	private int idcard;
	private int price;
	
	public Inventory(int iduser, int idcard, int price) {
		super();
		this.iduser = iduser;
		this.idcard = idcard;
		this.price = price;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getIdcard() {
		return idcard;
	}

	public void setIdcard(int idcard) {
		this.idcard = idcard;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}