package com.sp.repository;


import org.springframework.data.repository.CrudRepository;
import com.sp.model.TemplateCard;

public interface TemplateCardRepository extends CrudRepository<TemplateCard, Integer> {

	public TemplateCard findById(int id);
}