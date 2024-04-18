package com.estsoft.blogjpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
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
	@DisplayName("사용자 정보 조회")
	@Test
	public void testFindAll(){
		User user = new User("mcok_email","mock_password");
		userRepository.save(user);

		List<User> all = userRepository.findAll();
		assertEquals(1,all.size());
	}

	@DisplayName("사용저 정보 저장")
	@Test
	public void testUserSave(){
		User user = new User("mcok_email","mock_password");
		User returnUser = userRepository.save(user);

		assertEquals(user.getEmail(),returnUser.getEmail());
		assertEquals(user.getPassword(),returnUser.getPassword());
	}
}
