package com.sp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PutMapping("/cards")
    public void updateCard(@RequestBody CardDTO updatedCardDto) {
		Card existingCard = cardService.findCardById(updatedCardDto.getId());
		if (existingCard != null) {
	        Card updatedCard = new Card(updatedCardDto.getId(), updatedCardDto.getUserId(), updatedCardDto.getPrix(),
	                updatedCardDto.getName(), updatedCardDto.getDescription(), updatedCardDto.getImgUrl(),
	                updatedCardDto.getFamily(), updatedCardDto.getAffinity(), updatedCardDto.getHp(),
	                updatedCardDto.getEnergy(), updatedCardDto.getAttack(), updatedCardDto.getDefence());
	        cardService.updateCard(updatedCard);
		}
    }
	
	@DeleteMapping("/cards")
	public void deleteCard(@RequestBody CardDTO cardDTO) {
		Card card = new Card(cardDTO.getId(), cardDTO.getUserid(), cardDTO.getPrix(), cardDTO.getName(),
				cardDTO.getDescription(), cardDTO.getImgUrl(), cardDTO.getFamily(), cardDTO.getAffinity(), cardDTO.getHp(),
				cardDTO.getEnergy(), cardDTO.getAttack(), cardDTO.getDefence());
		cardService.deleteCard(card);
	}
	
	@GetMapping(value = {"/distribute"})
	public void distributeCards(@RequestParam("userId") int userId) {
		cardService.distributeFiveFirstCards(userId);
	}
	
	@GetMapping(value = {"/inventory/{userId}"})
	public List<CardDTO> getInventoryByUserId(@PathVariable int userId) {
		List<CardDTO> cardDtoList = new ArrayList<CardDTO>();
		for (Card card : cardService.getInventoryByUserId(userId)) {
			cardDtoList.add(new CardDTO(card.getId(), card.getUserid(), card.getPrix(), card.getName(),
					card.getDescription(), card.getImgUrl(), card.getFamily(), card.getAffinity(), card.getHp(),
					card.getEnergy(), card.getAttack(), card.getDefence()));
		}
		
		return cardDtoList;
	}
}