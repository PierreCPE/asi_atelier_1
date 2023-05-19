package com.sp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.model.CardDTO;
import com.sp.service.CardService;

@RestController
public class CardCrt {

	@Autowired
	CardService cardService;
	
	@RequestMapping(value = { "/cards" }, method = RequestMethod.GET)
	public List<CardDTO> getCard() {
		
		List<CardDTO> cardDtoList = new ArrayList<CardDTO>();
		for (Card card : cardService.getCards()) {
			cardDtoList.add(new CardDTO(card.getId(), card.getUserid(), card.getPrix(), card.getName(),
					card.getDescription(), card.getImgUrl(), card.getFamily(), card.getAffinity(), card.getHp(),
					card.getEnergy(), card.getAttack(), card.getDefence()));
		}
		
		return cardDtoList;
	}
	
	@RequestMapping(value = { "/cards/{cardId}" }, method = RequestMethod.GET)
	public CardDTO getCardById(@PathVariable int cardId) {
		Card card = cardService.findCardById(cardId);
		CardDTO cardDto = new CardDTO(card.getId(), card.getUserid(), card.getPrix(), card.getName(),
				card.getDescription(), card.getImgUrl(), card.getFamily(), card.getAffinity(), card.getHp(),
				card.getEnergy(), card.getAttack(), card.getDefence());
		return cardDto;
	}
	
	@GetMapping(value = {"/distribute"})
	public void distributeCards(@RequestParam("userId") int userId) {
		cardService.distributeFiveFirstCards(userId);
	}

}