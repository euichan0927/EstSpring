package com.estsoft.blogjpa.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.estsoft.blogjpa.domain.User;
import com.estsoft.blogjpa.domain.User1;
import com.estsoft.blogjpa.dto.AddUserRequest;
import com.estsoft.blogjpa.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	UserService userService;

	@Mock
	UserRepository userRepository;

	@Spy
	BCryptPasswordEncoder passwordEncoder;

	@DisplayName("회원 가입 테스트")
	@Test
	public void testSaveUser() {
		// given
		AddUserRequest addUser = new AddUserRequest("mock_email", "mock_password");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptPassword = encoder.encode(addUser.getPassword());

		doReturn(new User(addUser.getEmail(), encryptPassword))
			.when(userRepository)
			.save(any(User.class));

		// when
		User returnUser = userService.save(addUser);

		// then
		assertEquals(addUser.getEmail(), returnUser.getEmail());
		assertEquals(encryptPassword, returnUser.getPassword());

		verify(userRepository, times(1)).save(any(User.class));
		verify(passwordEncoder, times(1)).encode(any(String.class));
	}

}
