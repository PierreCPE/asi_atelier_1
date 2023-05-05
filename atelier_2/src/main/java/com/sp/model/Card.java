package com.sp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Card extends TemplateCard {
	@Id
	@GeneratedValue
	private Integer id;
	private int proprietaire;
	

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
	
	
}