package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.sp.model.Card;
import com.sp.model.Inventory;
import com.sp.model.User;
import com.sp.repository.InventoryRepository;

@Service
public class InventoryService{
	@Autowired
	InventoryRepository iRepo;
	
	/**
	 * Crée l'inventaire de l'utilisateur u
	 * @param u
	 */
	public void createInv(User u) {
		Optional<Inventory> iOpt = iRepo.findById(u.getId());
		if (!iOpt.isPresent()) {
			Inventory inv = new Inventory(u.getId());
			iRepo.save(inv);
		}
	}
	
	/**
	 * Ajoute la carte c dans l'inventaire de userid.
	 * Crée l'inventaire de userid s'il n'existe pas
	 * @param c
	 */
	public void addCardToInv(Card c, User u) {
		Optional<Inventory> iOpt = iRepo.findById(u.getId());
		if (!iOpt.isPresent()) {
			this.createInv(u);
		}
		Inventory inv = iOpt.get();
        inv.addCard(c);
        iRepo.save(inv);
	}
	
	public Inventory getInventory(int userid) {
		Optional<Inventory> iOpt = iRepo.findById(userid);
		if (iOpt.isPresent()) {
			return iOpt.get();
		}
		else {
			return null;
		}
	}
	
}