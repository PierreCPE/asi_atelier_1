package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue
	private Integer id;
	private int iduser1;
	private int iduser2;
	private int price;
	
	public Transaction() {
	}

	public Transaction( int iduser1, int iduser2, int price) {
		super();
		this.iduser1 = iduser1;
		this.iduser2 = iduser2;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIduser1() {
		return iduser1;
	}

	public void setIduser1(int iduser1) {
		this.iduser1 = iduser1;
	}

	public int getIduser2() {
		return iduser2;
	}

	public void setIduser2(int iduser2) {
		this.iduser2 = iduser2;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "TRANSACTION ["+this.id+"]: acheteur:"+this.iduser1+", vendeur:"+this.iduser2+", prix:"+this.price+"";
	}
}

