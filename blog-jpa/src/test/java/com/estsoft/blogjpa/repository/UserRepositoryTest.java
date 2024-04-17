package com.estsoft.blogjpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.estsoft.blogjpa.domain.User;

@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	void testFindByEmail(){
		//given
		User user = new User("mock_email","mock_password");
		userRepository.save(user);

		//when
		User returnUser = userRepository.findByEmail(user.getEmail()).orElseThrow();

		//then
		assertEquals(user.getEmail(),returnUser.getEmail());
		assertEquals(user.getPassword(),returnUser.getPassword());
	}
}
