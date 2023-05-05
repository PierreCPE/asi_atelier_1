  package com.sp.rest;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;


  import com.sp.model.TransactionRequest;
  import com.sp.service.TransactionService;
  import com.sp.service.UserService;
  import com.sp.service.CardService;


@RestController
public class StoreRestCrt {
	@Autowired
    TransactionService tservice;
	@Autowired
	UserService uservice;
	@Autowired
	CardService cservice;

	@RequestMapping("/buy")
	public String buy() {
		return "Vous etes la pour acheter !!!";
	}
	
	@RequestMapping("/sell")
	public String sell() {
		return "Vous etes la pour vendre !!!";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addtransaction")
	public void addTransaction(@RequestBody TransactionRequest tr) {
		tservice.addtransaction(tr);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/vente/{id1}/{id2}")
	public String getMsg(@PathVariable int iduser1, @PathVariable int iduser2) {
		int msg1=iduser1;
		int msg2=iduser2;
		return "Vente entre: acheteur:"+msg1+"vendeur:"+msg2;
	}
	
	
}

