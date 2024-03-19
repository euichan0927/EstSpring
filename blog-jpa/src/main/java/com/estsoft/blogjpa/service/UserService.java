package com.estsoft.blogjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estsoft.blogjpa.domain.User;
import com.estsoft.blogjpa.dto.AddUserRequest;
import com.estsoft.blogjpa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public User save(AddUserRequest dto){
		return userRepository.save(
			User.builder()
				.email(dto.getEmail()).password(encoder.encode(dto.getPassword())).build()
		);
	}
}
