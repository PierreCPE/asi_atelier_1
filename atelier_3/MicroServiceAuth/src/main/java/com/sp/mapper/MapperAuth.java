package com.sp.mapper;

import com.sp.model.Auth;
import com.sp.model.AuthDTO;

public class MapperAuth {
	
	public static AuthDTO toAuthDTO(Auth auth) {
		String name = auth.getUserName();
		String surname = auth.getSurname();
		int solde = auth.getSolde();

        return new AuthDTO(name, surname, solde);
	}
	
	public static AuthDTO toDB(Auth auth) {
		String name = auth.getUserName();
		String surname = auth.getSurname();
		int solde = auth.getSolde();

        return new AuthDTO(name, surname, solde);
	}
}

