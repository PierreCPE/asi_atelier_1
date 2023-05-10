package com.sp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.sp.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	public List<Transaction> findById(int id);
}
