package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.repository.TransactionRepository;

@Service
public class InventoryService{
	@Autowired
	TransactionRepository tRepository;
}