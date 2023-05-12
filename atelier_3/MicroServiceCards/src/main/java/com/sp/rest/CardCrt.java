package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sp.service.CardService;

@RestController
public class CardCrt {

	@Autowired
	CardService cardService;
	

}