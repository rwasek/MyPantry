package com.richardwasek.mypantry.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.richardwasek.mypantry.entities.Grocery;

@SpringBootTest
class GroceryRepositoryTest {
	
	@Autowired
	private GroceryRepository groRepo;

	@Test
	@DisplayName("find all groceries for user by username")
	void test1() {
		Set<Grocery> groceries = groRepo.findByUserUsername("rwasek");
		assertNotNull(groceries);
		assertTrue(groceries.size() > 0);
	}
	
	@Test
	@DisplayName("find all groceries for user by id")
	void test2() {
		Set<Grocery> groceries = groRepo.findByUserId(1);
		assertNotNull(groceries);
		assertTrue(groceries.size() > 0);
	}
	
	@Test
	@DisplayName("find by grocery ID and user username")
	void test3() {
		Grocery grocery = groRepo.findByIdAndUserUsername(1, "rwasek");
		assertNotNull(grocery);
		assertEquals("Loaf of Bread",grocery.getProductName());
	}
	
	@Test
	@DisplayName("find a single grocery by grocery ID")
	void test4() {
		Optional<Grocery> grocery = groRepo.findById(2);
		assertTrue(grocery.isPresent());
		assertEquals("Lettuce Box", grocery.get().getProductName());
	}
	
	@Test
	@DisplayName("find all groceries")
	void test5() {
		List<Grocery> groceries = groRepo.findAll();
		assertNotNull(groceries);
		assertTrue(groceries.size() > 0);
	}

}
