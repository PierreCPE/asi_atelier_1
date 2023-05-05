package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.sp.model.Inventory;
import com.sp.repository.InventoryRepository;

@Service
public class InventoryService{
	@Autowired
	InventoryRepository iRepository;

	public int getPrice(int idCard) {
		Optional<Inventory> hOpt =iRepository.findById(idCard);
		if (hOpt.isPresent()) {
			Inventory i = hOpt.get();
			return i.getPrice();
		}else {
			return -1;
		}
	}
	
}