package com.atelier3.MicroServices.MicroServiceUsers.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UserTest {

	private List<String> stringList;
	private List<Integer> intList;

	@BeforeEach
	public void setUp() {
		System.out.println("[BEFORE TEST] -- Add User to test");
		stringList = new ArrayList<String>();
		intList = new ArrayList<Integer>();
		stringList.add("normalString1");
		stringList.add("normalString2");
		stringList.add(";:!;!::!;;<>");
		intList.add(5);
		intList.add(500);
		intList.add(-1);
	}

	@AfterEach
	public void tearDown() {
		System.out.println("[AFTER TEST] -- CLEAN user list");
		stringList = null;
		intList = null;
	}
	
	@Test
	public void createHero() {
		for(String msg:stringList) {
			for(String msg2:stringList) {
				for(String msg3:stringList) {
					for(Integer msg4:intList) {
						Users u=new Users(msg4, msg, msg2, msg3, msg4);
						System.out.println("msg:"+msg+", msg2:"+msg2+", msg3:"+msg3+", msg4:"+msg4);
						assertTrue(u.getId().intValue() == msg4.intValue());
						assertTrue(u.getUsername() == msg);
						assertTrue(u.getSurname() == msg2);
						assertTrue(u.getSolde() == msg4);
						assertTrue(u.getPassword() == msg3);
					}	
				}	
			}
		}

	}

	@Test
	public void displayHero() {
		Users u=new Users(1,"jdoe", "jdoe", "jdoepwd", 1000);
		String expectedResult="User [id=1, username=jdoe, surname=jdoe, password=jdoepwd, solde=1000]";
		assertTrue(u.toString().equals(expectedResult));
		
	}


	
}
