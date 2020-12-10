package com.richardwasek.mypantry.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.richardwasek.mypantry.entities.User;

@SpringBootTest
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepo;

	@Test
	@DisplayName("find user by username")
	void test1() {
		User user = userRepo.findByUsername("rwasek");
		assertNotNull(user);
		assertEquals("rwasek", user.getUsername());
		assertEquals("Rich", user.getFirstName());
		assertEquals("Wasek", user.getLastName());
		assertEquals("rideburtonrw@gmail.com", user.getEmail());
	}
	
	@Test
	@DisplayName("find by ID")
	void test2() {
		Optional<User> user = userRepo.findById(1);
		User userTest = user.get();
		assertEquals("rwasek", userTest.getUsername());
	}

}
