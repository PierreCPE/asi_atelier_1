package com.sp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.sp.model.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

	public List<Inventory> findByName(String name);
}
