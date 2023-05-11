
package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.Inventory;
import com.sp.model.TransactionDTO;
import com.sp.model.Transaction;
import com.sp.model.User;
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
	
	/**
	 * Effectue l'achat d'une carte par un utilisateur
	 * @param transactionDTO
	 * @return un booléen indiquant si l'achat a pû être effectué
	 */
	
	public boolean buyCard(TransactionDTO transactionDTO) {
		
		boolean achatEffectue = false;
		User acheteur = uservice.getUser(transactionDTO.getIdacheteur());
		Transaction t;
		int prix;
		User vendeur;
		
		Optional<Transaction> tOpt = tRepository.findById(transactionDTO.getIdcard());
		
		
		// Vérifie si la carte est bien mise en vente
		if (tOpt.isPresent()) {
			t = tOpt.get();
			// Récupère son prix et son vendeur
			prix = t.getPrice();
			vendeur = uservice.getUser(t.getIdVendeur());

			if (acheteur.getSolde()>=prix) {
				c.setProprietaire(transactionDTO.getIdacheteur());
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
