
package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.TransactionRequest;
import com.sp.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository tRepository;
	@Autowired
	UserService uservice;
	@Autowired
	InventoryService iservice;
	@Autowired
	CardService cservice;
	
	
	public String addtransaction(TransactionRequest tr) {
		int idAcheteur = tr.getIdacheteur();
		int idCard = tr.getIdcard();
		int accountAcheteur = uservice.getSolde(idAcheteur);
		if (accountAcheteur < 0) {
			return "There is a problem with your sold";
		}
		int priceCard = iservice.getPrice(idCard);
		if (accountAcheteur <= priceCard) {
			return " You don't have enough money to buy this card";
		}
		else {
			
			return " Transaction done ";
		}
		//Transaction createdTransaction=tRepository.save(t);
		//System.out.println(createdTransaction);
	}

}
