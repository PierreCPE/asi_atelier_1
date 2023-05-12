package com.sp.mapper;

import com.sp.model.Card;
import com.sp.model.TemplateCard;

public class MapperCard {
	
	public static Card TemplateCardtoCard(TemplateCard tc) {
		Card c = new Card();
		c.setName(tc.getName());
		c.setDescription(tc.getDescription());
		c.setImgUrl(tc.getImgUrl());
		c.setFamily(tc.getFamily());
		c.setAffinity(tc.getAffinity());
		c.setHp(tc.getHp());
		c.setEnergy(tc.getEnergy());
		c.setAttack(tc.getAttack());
		c.setDefence(tc.getDefence());
		return c;
	}
}