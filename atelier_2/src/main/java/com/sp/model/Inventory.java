package com.sp.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Inventory {
	@Id
	private Integer iduser;
	@ElementCollection
	private List<Card> deck;
	
	public Inventory(Integer iduser) {
		this.iduser = iduser;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void addCard(Card c) {
		this.deck.add(c);
	}
}