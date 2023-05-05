package com.sp.model;

public class TransactionRequest{
	private int idacheteur;
	private int idcard;
	
	
	public TransactionRequest(int idacheteur, int idcard) {
		super();
		this.idacheteur= idacheteur;
		this.idcard = idcard;
	}
	public int getIdacheteur() {
		return idacheteur;
	}
	public void setIdacheteur(int idacheteur) {
		this.idacheteur = idacheteur;
	}
	public int getIdcard() {
		return idcard;
	}
	public void setIdcard(int idcard) {
		this.idcard = idcard;
	}
	
	
}