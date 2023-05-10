
package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.repository.TransactionRepository;

@Service
public class TransactionService {
//	@Autowired
//	TransactionRepository tRepository;
	@Autowired
	UserService uservice;
	@Autowired
	InventoryService iservice;
	@Autowired
	CardService cservice;
	

	
	public boolean buyCard(int cardid, int userid) {
		Card c = cservice.getCard(cardid);
		User u = uservice.getUser(userid);
		int prix = c.getPrix();
		
		if (u.getSolde()>=prix) {
			c.setProprietaire(userid);
			u.debit(prix);
			iservice.addCardToInv(c, u);
			cservice.updateCard(c);
			uservice.updateUser(u);
			return true;
		}
		else {
			return false;
		}
	}
	
	public void sellCard(int cardid, int userid) {
		Card c = cservice.getCard(cardid);
		User u = uservice.getUser(userid);
		int prix = c.getPrix();
		
		if (iservice.removeCardFromInv(c, u)) {
			u.credit(prix);
		}
	}

}
