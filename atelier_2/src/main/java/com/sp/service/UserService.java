package com.sp.service;

import org.springframework.stereotype.Service;

import com.sp.model.User;


@Service
public class UserService {
	
	public void addUser(User u){
		System.out.println(u);
	}
	
	public User getUser(int id) {
		return null;
	}
}
