package com.richardwasek.mypantry.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardwasek.mypantry.entities.User;
import com.richardwasek.mypantry.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
