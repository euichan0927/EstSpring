package com.estsoft.blogjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.estsoft.blogjpa.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	public UserDetailService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException(email));
	}
}
