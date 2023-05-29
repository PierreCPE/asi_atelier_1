package com.atelier3.MicroServices.MicroServiceUsers.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.atelier3.MicroServices.MicroServiceUsers.model.UserRegisterDTO;
import com.atelier3.MicroServices.MicroServiceUsers.model.Users;
import com.atelier3.MicroServices.MicroServiceUsers.repository.UsersRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UsersService.class)
class UsersServiceTest {

	@MockBean
	private UsersRepository uRepo;
	
	
	
	@Autowired
	private UsersService uService;
	
	Users tmpUser=new Users(1, "jdoe", "jdoe", "jdoepwd", 1000);
	
	@Test
	public void getUser() {
		Mockito.when(
				uRepo.findById(Mockito.any())
				).thenReturn(Optional.ofNullable(tmpUser));
		Users userInfo=uService.getUser(1);
		assertTrue(userInfo.toString().equals(tmpUser.toString()));
	}
	

	
	@Test 
	public void addUser() {
		
		Users user = new Users(1, "jdoeun", "jdoesn", "jdoepwd", 1000);
		
		Mockito.when(
				uRepo.findByUsernameAndPassword(Mockito.any(), Mockito.any())
				).thenReturn(new ArrayList<Users>());
		Mockito.when(
				uRepo.save(Mockito.any(Users.class))).thenReturn(user);
		UsersService spy = Mockito.spy(uService);
		Mockito.doNothing().when(spy).distributeCards(Mockito.any());
		
		
		UserRegisterDTO userDTO = new UserRegisterDTO();
		userDTO.setUsername("jdoeun");
		userDTO.setSurname("jdoesn");
		userDTO.setPassword("jodepwd");
		boolean trace = spy.addUser(userDTO);
		verify(uRepo, times(1)).save(Mockito.any(Users.class));
		assertTrue(trace);
	}


}
