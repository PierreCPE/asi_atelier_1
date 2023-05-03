package com.sp.service;

import org.springframework.stereotype.Service;
import com.sp.model.Card;

@Service
public class CardService {
	
	public Card getCard(int id) {
		return new Card();
	}
}