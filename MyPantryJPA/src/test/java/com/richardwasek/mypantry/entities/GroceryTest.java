package com.richardwasek.mypantry.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.crypto.AEADBadTagException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GroceryTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Grocery grocery;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("MyPantryPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		grocery = em.find(Grocery.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		grocery = null;
		em.close();
	}

	@Test
	@DisplayName("testing grocery mappings")
	void test1() {
		assertNotNull(grocery);
		assertEquals("Loaf of Bread",grocery.getProductName());
		assertEquals(1,grocery.getAmount());
		assertEquals(0.2,grocery.getAmountUsed());
		assertEquals("Pantry", grocery.getCategory().getCategoryName());
		assertEquals(21, grocery.getDateOpened().getDayOfMonth());
		assertEquals(2020, grocery.getDatePurchased().getYear());
		assertEquals(null, grocery.getExpirationDate());
	}

}
