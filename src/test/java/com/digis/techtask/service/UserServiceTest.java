package com.digis.techtask.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.digis.techtask.model.User;
import com.digis.techtask.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Test
	public void createUser() {

		User user = User.builder().id(1L).dob(LocalDate.now()).fullname("Christian Ontiveros").login("Erso Skywalker")
				.gender('M').build();
		// I'm not implementing DTOs, but here I would use the DTO.
		User userReceived = User.builder().dob(LocalDate.now()).fullname("Christian Ontiveros").login("Erso Skywalker")
				.gender('M').build();
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		User userResponse = userService.createUser(userReceived);

		assertNotNull(userResponse);

	}

	@Test
	public void getAllUsers() {
		List<User> users = Mockito.anyList();
		when(userRepository.findAll()).thenReturn(users);

		List<User> usersResult = userService.getAllUsers();

		assertNotNull(usersResult);

	}

	@Test
	public void updateUser() {

		User user = User.builder().id(1L).dob(LocalDate.now()).fullname("Christian Ontiveros").login("Skywalker")
				.gender('M').build();
		User userReceived = User.builder().id(1L).dob(LocalDate.now()).fullname("Christian Ontiveros")
				.login("Skywalker").gender('M').build();
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		User userResponse = userService.updateUser(userReceived);

		assertNotNull(userResponse);

	}

}
