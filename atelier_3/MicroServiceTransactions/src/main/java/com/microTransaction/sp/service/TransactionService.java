
package com.microTransaction.sp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microTransaction.sp.mapper.MapperTransaction;
import com.microTransaction.sp.model.TransactionDTO;
import com.microTransaction.sp.model.UserDTO;
import com.microTransaction.sp.model.CardDTO;
import com.microTransaction.sp.model.Transaction;
import com.microTransaction.sp.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository tRepository;
	
	static final String URL_CARD = "http://microservice-cards:8080/cards/{cardId}";
	static final String URL_USER = "http://localhost:8081/users/{userid}";
	
	private final RestTemplate restTemplate;

	public TransactionService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	/**
	 * Effectue l'achat d'une carte par un utilisateur
	 * @param transactionDTO
	 * @return un booléen indiquant si l'achat a pû être effectué
	 */
	public void addTransaction(TransactionDTO transactionDTO) {
		int idAcheteur = transactionDTO.getIduser();
		int idCard = transactionDTO.getIdcard();
		
		// Contacte service CARD avec un param idCard pour avoir la CardDTO et en extraire le prix
		String URL_forPrice = URL_CARD.replace("{cardId}", Integer.toString(idCard));
		CardDTO card = this.restTemplate.getForObject(URL_forPrice, CardDTO.class);
		int price = card.getPrix();
		int idVendeur = card.getUserId();
		
		// Contacte service USER avec un param idAcheteur pour avoir le UserDTO et en extraire le solde
		String URL_forSold = URL_USER.replace("{userid}", Integer.toString(idAcheteur));
		UserDTO user = this.restTemplate.getForObject(URL_forSold, UserDTO.class);
		int soldAcheteur = user.getSolde();
		
		if (soldAcheteur >= 0) { // Vérifie que l'acheteur existe
			if (price >= 0) {
				if (soldAcheteur >= price) { // Vérifie que l'acheteur possède l'argent necessaire
					log = "Achat effectué";
					//TODO modifier le proprietaire
					//TODO modifier le solde de l'acheteur
					//TODO modifier le solde du vendeur
					//TODO retirer du market
					Transaction t = MapperTransaction.TransactionDTOtoTransaction(transactionDTO,idVendeur,price);
					tRepository.save(t);
				}
				else {
					log = "Fond insuffisant";
				}
			}
			else {
			log = " Carte pas à vendre";
			}
		}
		else {
			log = "Erreur sur l'acheteur";
		}					
	}

		
	/*
	
	
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
