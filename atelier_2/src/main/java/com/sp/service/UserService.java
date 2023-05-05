package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;
import com.sp.model.Card;
import com.sp.model.CardTemplate;
import com.sp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository uRepository;
	
	@Autowired
	CardService cardService;
	
	public void addUser(User u){
		uRepository.save(u);
		List<CardTemplate> firstCardsTemplate = cardService.getFiveFirstCards();
		List<Card> firstCards = new ArrayList<Card>();
		for (CardTemplate template:firstCardsTemplate) {
			Card card = new Card(template, u.id_user);
			cardService.addCard(card);
		}
		return 
	
	}
	
	public User getUser(int id) {
		return null;
	}
}
