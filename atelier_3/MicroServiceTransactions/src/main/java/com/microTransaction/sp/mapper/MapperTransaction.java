package com.microTransaction.sp.mapper;

import com.microTransaction.sp.model.*;

public class MapperTransaction {
	
	public static Transaction TransactionDTOtoTransaction(TransactionDTO transactionDTO) {
		Transaction transaction = new Transaction();
		transaction.setIdCard(transactionDTO.getIdcard());
		transaction.setIdVendeur(transactionDTO.getIduser());
		//TODO recuperer idAcheteur et price
		return transaction;
	}
	
	public static TransactionDTO TransactiontoTransactionDTO(Transaction transaction) {
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setIdcard(transaction.getIdCard());
		transactionDTO.setIduser(transaction.getIdVendeur());
		return transactionDTO;
	}
	
}
st