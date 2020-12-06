package com.richardwasek.mypantry.services;

import java.util.List;

import com.richardwasek.mypantry.entities.Grocery;
import com.richardwasek.mypantry.entities.User;

public interface UserService {
	User findByUsername(String username);
}
