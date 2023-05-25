package com.sp.repository;


import org.springframework.data.repository.CrudRepository;

import com.sp.model.Card;

public interface MarketRepository extends CrudRepository<Card, Integer> {

	public Card findById(int id);
}