package com.atelier3.MicroServices.MicroServiceUsers.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.atelier3.MicroServices.MicroServiceUsers.model.Users;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	UsersRepository urepo;
	
	@BeforeEach
	public void setUp() {
		urepo.save(new Users(1, "jdoe", "jdoe","jdoepwd", 5000));
	}

	@AfterEach
	public void cleanUp() {
		urepo.deleteAll();
	}

	
	@Test
	public void saveUser() {
		urepo.save(new Users(1, "testun", "testsn", "testPwd", 1000));
		assertTrue(true);
	}

	@Test
	public void saveAndGetHero() {
		urepo.deleteAll();
		urepo.save(new Users(2, "testun2", "testsn2", "testPwd2", 1000));
		List<Users> userList = new ArrayList<>();
		urepo.findAll().forEach(userList::add);
		assertTrue(userList.size() == 1);
		assertTrue(userList.get(0).getUsername().equals("testun2"));
		assertTrue(userList.get(0).getSurname().equals("testsn2"));
		assertTrue(userList.get(0).getPassword().equals("testPwd2"));
		assertTrue(userList.get(0).getSolde() == 1000);
	}

	@Test
	public void getHero() {
		List<Users> userList = urepo.findByUsernameAndPassword("jdoe", "jdoepwd");
		assertTrue(userList.size() == 1);
		assertTrue(userList.get(0).getUsername().equals("jdoe"));
		assertTrue(userList.get(0).getSurname().equals("jdoe"));
		assertTrue(userList.get(0).getPassword().equals("jdoepwd"));
		assertTrue(userList.get(0).getSolde() == 5000);
		
	}

	@Test
	public void findByName() {
		urepo.save(new Users(2, "testu1", "testsn1", "testPwd1", 1000));
		urepo.save(new Users(3, "testun2", "testsn2", "testPwd2", 1000));
		urepo.save(new Users(4, "testun2", "testsn2", "testPwd2", 1000));
		urepo.save(new Users(5, "testun2", "testsn2", "testPwd2", 1000));
		List<Users> userList = new ArrayList<>();
		userList = urepo.findByUsernameAndPassword("testun2", "testPwd2");
		System.out.println(userList);
		assertTrue(userList.size() == 3);
	}

	

}
