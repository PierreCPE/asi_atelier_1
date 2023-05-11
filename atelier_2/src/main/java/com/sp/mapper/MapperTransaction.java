package com.sp.mapper;

import com.sp.model.Transaction;
import com.sp.model.TransactionDTO;

public class MapperTransaction {

	public static Transaction TransactionDTOtoTransaction(TransactionDTO transactionDTO) {
		Transaction transaction = new Transaction();
		transaction.setIdCard(transactionDTO.getIdcard());
		transaction.setIdVendeur(transactionDTO.getIduser());
		return transaction;
	}
	
}
