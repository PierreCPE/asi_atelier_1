package com.microTransaction.sp.repository;

import org.springframework.data.repository.CrudRepository;
import com.microTransaction.sp.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

}
