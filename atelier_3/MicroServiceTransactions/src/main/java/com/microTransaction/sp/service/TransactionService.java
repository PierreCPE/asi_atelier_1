
package com.microTransaction.sp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microTransaction.sp.mapper.MapperTransaction;
import com.microTransaction.sp.model.TransactionDTO;
import com.microTransaction.sp.model.Transaction;
import com.microTransaction.sp.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository tRepository;
	
	static final String URL_USER = "http://localhost:8081/user";
	/**
	 * Effectue l'achat d'une carte par un utilisateur
	 * @param transactionDTO
	 * @return un booléen indiquant si l'achat a pû être effectué
	 */
	public String buyCard(TransactionDTO transactionDTO) {
		boolean achatEffectue = false;
		
		// RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Send request with GET methods.
		String requestBody = Integer.toString(transactionDTO.getIdcard());
		// HttpEntity<String>: To get result as String.
		HttpEntity<String> entity = new HttpEntity<String>(requestBody);
		ResponseEntity<String> response = restTemplate.exchange(URL_USER, HttpMethod.GET, entity, String.class);
		int idAcheteur = Integer.parseInt(response.getBody());

				
	}
		
	/*
	public String buyCard(TransactionDTO transactionDTO) {
		
		boolean achatEffectue = false;
		User acheteur = uservice.getUser(transactionDTO.getIduser());
		Card c = cservice.getCard(transactionDTO.getIdcard());
		Transaction t;
		int prix;
		User vendeur;
		String log = "";
		
		Optional<Transaction> tOpt = tRepository.findById(transactionDTO.getIdcard());
		
		
		// Vérifie si la carte est bien mise en vente
		if (tOpt.isPresent()) {
			t = tOpt.get();
			// Récupère son prix et son vendeur
			prix = t.getPrice();
			vendeur = uservice.getUser(t.getIdVendeur());
			
			//Vérifie que le vendeur et l'acheetur existent
			
			if (!(vendeur == null) && !(acheteur == null)) {
				
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
					log = "Achat effectué";
				} else {
					log = "Solde insuffisant";
				}
			} else {
				log = "Erreur sur les utilisateurs";
			}
		} else {
			log = "Cette carte n'est pas en vente";
		}
		return log;
	}
	
	public String sellCard(TransactionDTO transactionDTO) {
		
		String log;
		Optional<Transaction> tOpt = tRepository.findById(transactionDTO.getIdcard());
		Card c = cservice.getCard(transactionDTO.getIdcard());
		User u = uservice.getUser(transactionDTO.getIduser()); 
		int prix;
		
		if (tOpt.isEmpty() && !(c == null) && !(u == null)) {
			prix = c.getPrix();
			if (iservice.removeCardFromInv(c, u)) {
				Transaction transaction = MapperTransaction.TransactionDTOtoTransaction(transactionDTO);
				transaction.setPrice(prix);
				tRepository.save(transaction);
				log = "Mise en vente effectuée";
			} else {
				log = "Cette carte n'appaartient pas à cet  utilisateur";
			}
		} else {
			log = "Carte ou utilisateur introuvable";
		}
	    return log;
	}

	public List<TransactionDTO> getTransactions() {
		List<TransactionDTO> res = new ArrayList<TransactionDTO>();
	    Iterable<Transaction> list = tRepository.findAll();
	    for (Transaction transaction:list) {
	    	res.add(MapperTransaction.TransactiontoTransactionDTO(transaction));
	    }
	    return res;
	}
	*/
	
}
