package com.sp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sp.model.Card;
import com.sp.model.TemplateCard;
import com.sp.repository.CardRepository;
import com.sp.repository.TemplateCardRepository;


@Service
public class CardService {
	Boolean isInit = false;
	@Autowired
	TemplateCardRepository tcRepo;
	CardRepository cRepo;
	
	/**
	 * Initialise le repo card template
	 */
	public void tcRepoInit() {
		tcRepo.save(new TemplateCard("Pickachu", "electric mouse", "https://media.tenor.com/ihqN6a3iiYEAAAAd/pikachu-shocked-face-stunned.gif", "mouse family", "electric", 10, 20, 20, 10));
		tcRepo.save(new TemplateCard("Charmander", "fire lizard", "https://media1.giphy.com/media/WJ7Tr9wi8xVe0/giphy.gif", "lizard family", "fire", 30, 20, 50, 10));
		tcRepo.save(new TemplateCard("Squirtle", "water tortoise", "https://media.tenor.com/Ken3eHIfWnAAAAAM/pokemon-squirtle.gif", "tortoise family", "water", 30, 10, 20, 1));
		tcRepo.save(new TemplateCard("Bulbasaur", "plant with 4 leg", "https://media.tenor.com/_B4QaT_C3WsAAAAM/bulbasaur-pokemon.gif", "plant family", "plant", 8, 20, 20, 2));
		tcRepo.save(new TemplateCard("Pidgey", "juste un pigeon en vrai", "https://media.tenor.com/9y3ql3fTKMMAAAAC/pidgey-cute.gif", "bird family", "flying", 10, 6, 20, 10));
		System.out.println("Repo card template initialisé");
		this.isInit = true;
	}
	
	public void addToCardRepo(Card c) {
		cRepo.save(c);
	}
	
	/**
	 * Retourne 5 cartes aléatoires pour un nouvel utilisateur
	 * @return
	 */
	public List<TemplateCard> getFiveFirstCards() {
	    List<TemplateCard> cardList = new ArrayList<>();
	    List<TemplateCard> allCards = (List<TemplateCard>) tcRepo.findAll();

	    Random rand = new Random();
	    Set<Integer> selectedIndexes = new HashSet<>();
	    while (selectedIndexes.size() < 5) {
	        int index = rand.nextInt(allCards.size());
	        if (!selectedIndexes.contains(index)) {
	            selectedIndexes.add(index);
	            cardList.add(allCards.get(index));
	        }
	    }
	    return cardList;
	}
	
	public int getPrice(int idcard) {
		Optional<Card> card = cRepo.findById(idcard);
		if (card.isPresent()) {
			return card.get().getPrix();
		}
		else {
			return -1;
		}
	}

	
	public Card getCard(int id) {
		Optional<Card> c0pt = tcRepo.findById(id);
		if (c0pt.isPresent()) {
			return c0pt.get();
		}
		else {
			return null;
		}
	}
}