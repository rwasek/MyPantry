package com.richardwasek.mypantry.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.richardwasek.mypantry.entities.Category;

@SpringBootTest
class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository catRepo;

	@Test
	@DisplayName("find all categories")
	void test1() {
		List<Category> categories = catRepo.findAll();
		assertNotNull(categories);
		assertTrue(categories.size() > 0);
	}
	
	@Test
	@DisplayName("find a single category by ID")
	void test2() {
		Optional<Category> category = catRepo.findById(1);
		assertTrue(category.isPresent());
		assertEquals("Vegetable", category.get().getCategoryName());
	}

}
