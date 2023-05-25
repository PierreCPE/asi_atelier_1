
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
	static final String URL_CARDS = "http://microservice-cards:8080/cards";
	static final String URL_USER = "http://localhost:8081/users/{userid}";
	static final String URL_USERS = "http://localhost:8081/users";
	
	private final RestTemplate restTemplate;

	public TransactionService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	/**
	 * Effectue l'achat d'une carte par un utilisateur
	 * @param transactionDTO
	 */
	public void addTransaction(TransactionDTO transactionDTO) {
		int idAcheteur = transactionDTO.getIdbuyer();
		int idCard = transactionDTO.getIdcard();
		
		// Contacte service CARD avec un param idCard pour avoir la CardDTO et en extraire le prix
		String URL_card = URL_CARD.replace("{cardId}", Integer.toString(idCard));
		CardDTO cardDTO = this.restTemplate.getForObject(URL_card, CardDTO.class);
		
		// Contacte service USER avec un param idAcheteur pour avoir le UserDTO et en extraire le solde
		String URL_buyer = URL_USER.replace("{userid}", Integer.toString(idAcheteur));
		UserDTO userdto = this.restTemplate.getForObject(URL_buyer, UserDTO.class); //On suppose que l'user existe bel et bien
		
		if ((userdto != null) && (cardDTO != null)) { // Vérifie que l'acheteur et la carte existent
			int soldAcheteur = userdto.getSolde();
			int price = cardDTO.getPrix();
			int idVendeur = cardDTO.getUserId();
			if (price >= 0) {
				if (soldAcheteur >= price) {
					cardDTO.setUserId(userdto.getId());
					userdto.setSolde(soldAcheteur - price);
					String URL_seller = URL_USER.replace("{userid}", Integer.toString(idVendeur));
					UserDTO userdtoVendeur = this.restTemplate.getForObject(URL_seller, UserDTO.class);
					userdtoVendeur.setSolde(userdtoVendeur.getSolde() + price);
					this.restTemplate.put(URL_CARDS, cardDTO);
					this.restTemplate.put(URL_USERS, userdtoVendeur);
					this.restTemplate.put(URL_USERS, userdto);
					Transaction t = MapperTransaction.TransactionDTOtoTransaction(transactionDTO,idVendeur,price);
					tRepository.save(t);
				}
				else {
					System.out.println("Fonds insuffisants");
				}
			}
			else {
				System.out.println("Carte pas à vendre");
			}
		}
		else {
			System.out.println("Acheteur ou carte inexistante");
		}					
	}
}
