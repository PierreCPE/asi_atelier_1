package com.sp.model;

public class Poney  {

	private String color;
	private String superPower;
	private String name;
	private String imgUrl;

	public Poney() {
		this.color = "";
		this.superPower = "";
		this.name = "";
		this.imgUrl="";
	}
	public Poney(String name,String color,String superPower, String imgUrl) {
		this.color = color;
		this.superPower = superPower;
		this.name = name;
		this.imgUrl=imgUrl;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSuperPower() {
		return superPower;
	}
	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;	
	}
}
