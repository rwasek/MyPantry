package com.richardwasek.mypantry.services;

import com.richardwasek.mypantry.entities.User;

public interface UserService {
	User findByUsername(String username);
}
