package com.sp.repository;


import org.springframework.data.repository.CrudRepository;
import com.sp.model.Card;

public interface TemplateCardRepository extends CrudRepository<Card, Integer> {

	public Card findById(int id);
}