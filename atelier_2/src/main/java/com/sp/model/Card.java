package com.sp.model;

public class Card  {
	private String name;
	private String description;
	private String imgUrl;
	private String family;
	private String affinity;
	private int hp;
	private int energy;
	private int attack;
	private int defence;
	
	

	public Card() {
		this.name = "";
		this.description = "";
		this.imgUrl="";
		this.family = "";
		this.affinity = "";
		this.hp = 0;
		this.energy = 0;
		this.attack = 0;
		this.defence = 0;
		
		
	}
	public Card(String name,String description, String imgUrl,String family,String affinity,int hp,int energy,int attack,int defence) {
		this.name = name;
		this.description = description;		
		this.imgUrl=imgUrl;
		this.family = name;
		this.affinity = name;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
		
	}

  // GETTER AND SETTER
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;	
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	
	
	public String getAffinity() {
		return affinity;
	}
	public void setAffinity(String affinity) {
		this.affinity = affinity;
	}
	
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	@Override
	public String toString() {
		return "CECI EST UNE CARTE";
	}
	

}
