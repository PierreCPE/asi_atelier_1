package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
public class Card extends TemplateCard {
	@GeneratedValue
	private Integer id;
	private int proprietaire;
	private int prix;
	

	public Card() {
		super();
	}
	
	public Card(int userid) {
		super();
		this.proprietaire = userid;
	}

	public int getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(int proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Integer getId() {
		return id;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
}