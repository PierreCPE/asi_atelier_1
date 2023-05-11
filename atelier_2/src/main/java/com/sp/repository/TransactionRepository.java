package com.sp.repository;

import org.springframework.data.repository.CrudRepository;
import com.sp.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
