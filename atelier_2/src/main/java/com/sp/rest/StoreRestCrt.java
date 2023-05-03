package com.sp.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Transaction;


@RestController
public class StoreRestCrt {
	
	@RequestMapping("/buy")
	public String buy() {
		return "Vous etes la pour acheter !!!";
	}
	
	@RequestMapping("/sell")
	public String sell() {
		return "Vous etes la pour vendre !!!";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addtransaction")
	public void addTransaction(@RequestBody Transaction transaction) {
		System.out.println(transaction);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/vente/{id1}/{id2}")
	public String getMsg(@PathVariable String iduser1, @PathVariable String iduser2) {
		String msg1=iduser1;
		String msg2=iduser2;
		return "Vente entre: acheteur:"+msg1+"vendeur:"+msg2;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/infos")
	public String getInfoParam(@RequestParam String param1,@RequestParam String param2) {
		return "Parameters: param1:"+param1+"param2:"+param2;
	}
}

