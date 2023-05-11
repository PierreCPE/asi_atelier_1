
package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.mapper.MapperTransaction;
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
		User acheteur = uservice.getUser(transactionDTO.getIduser());
		Card c = cservice.getCard(transactionDTO.getIdcard());
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
			
			//Vérifie que le vendeur et l'acheetur existent
			
			if (!(vendeur.equals(null) && !(acheteur.equals(null)))) {
				
				//Vérifie que l'acheteur a assez d'argent
				if (acheteur.getSolde()>=prix) {
					c.setProprietaire(transactionDTO.getIduser());
					acheteur.debit(prix);
					vendeur.credit(prix);
					iservice.addCardToInv(c, acheteur);
					cservice.updateCard(c);
					t.setIdAcheteur(transactionDTO.getIduser());
					uservice.updateUser(acheteur);
					uservice.updateUser(vendeur);
					achatEffectue = true;
				}
			}
		}
		return achatEffectue;
	}
	
	public boolean sellCard(TransactionDTO transactionDTO) {
		
		boolean venteEffectue= false;
		Optional<Transaction> tOpt = tRepository.findById(transactionDTO.getIdcard());
		Card c = cservice.getCard(transactionDTO.getIdcard());
		User u = uservice.getUser(transactionDTO.getIduser()); 
		int prix;
		
		if (tOpt.isEmpty() && !(c.equals(null) && !(u.equals(null)))) {
			prix = c.getPrix();
			if (iservice.removeCardFromInv(c, u)) {
				Transaction transaction = MapperTransaction.TransactionDTOtoTransaction(transactionDTO);
				transaction.setPrice(prix);
				tRepository.save(transaction);
				venteEffectue = true;
			}
		}
	    return venteEffectue;	
	}

}
