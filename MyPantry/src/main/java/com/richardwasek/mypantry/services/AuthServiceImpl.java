package com.richardwasek.mypantry.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.richardwasek.mypantry.entities.Role;
import com.richardwasek.mypantry.entities.User;
import com.richardwasek.mypantry.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserRepository userRepo;

	@Override
	public User register(User user) {
		String encodedPW = encoder.encode(user.getPassword());
		user.setPassword(encodedPW); // only persist the encoded password
		
		// set other fields to default values; enabled to true; set the role to standard
		user.setEnabled(true);
		user.setRole(Role.STANDARD);
		userRepo.saveAndFlush(user);
		return user;
	}

}
