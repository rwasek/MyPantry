package com.richardwasek.mypantry.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardwasek.mypantry.entities.Category;
import com.richardwasek.mypantry.entities.Grocery;
import com.richardwasek.mypantry.entities.User;
import com.richardwasek.mypantry.repositories.CategoryRepository;
import com.richardwasek.mypantry.repositories.GroceryRepository;
import com.richardwasek.mypantry.repositories.UserRepository;

@Service
public class GroceryServiceImpl implements GroceryService {

	@Autowired
	GroceryRepository groRepo;
	@Autowired
	CategoryRepository catRepo;
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Set<Grocery> index(String username) {
		return groRepo.findByUserUsername(username);
	}

	@Override
	public Grocery showByIdAndUser(String username, int groceryId) {
		return groRepo.findByIdAndUserUsername(groceryId, username);
	}
// To have category in the API route: 
//	@Override
//	public Grocery createGrocery(int categoryId, String username, Grocery grocery) {
//		Optional<Category> catOpt = catRepo.findById(categoryId);
//		Category cat = catOpt.get();
//		grocery.setCategory(cat);
//		User user = userRepo.findByUsername(username);
//		if (user != null) {
//			grocery.setUser(user);
//			groRepo.saveAndFlush(grocery);
//			return grocery;
//		}
//		return null;
//	}
	@Override
	public Grocery createGrocery(String username, Grocery grocery) {
		Optional<Category> optCat = catRepo.findById(grocery.getCategory().getId());
		Category cat = optCat.get();
		User user = userRepo.findByUsername(username);
		if (user != null) {
			grocery.setCategory(cat);
			grocery.setUser(user);
			groRepo.saveAndFlush(grocery);
			return grocery;
		}
		return null;
	}

	@Override
	// FIX
	public Grocery updateGrocery(String username, int groceryId, Grocery grocery) {
		
		Grocery existingGrocery = groRepo.findByIdAndUserUsername(groceryId, username);
		if (existingGrocery != null) {
			existingGrocery.setAmount(grocery.getAmount());
			existingGrocery.setAmountUsed(grocery.getAmountUsed());
			existingGrocery.setCategory(grocery.getCategory());
			existingGrocery.setDateOpened(grocery.getDateOpened());
			existingGrocery.setDatePurchased(grocery.getDatePurchased());
			existingGrocery.setExpirationDate(grocery.getExpirationDate());
			existingGrocery.setProductName(grocery.getProductName());
			groRepo.saveAndFlush(existingGrocery);
		}
		return existingGrocery;
	}

	@Override
	public boolean deleteGrocery(String username, int groceryId) {
		boolean wasDeleted = false;
		Grocery toBeDeleted = groRepo.findByIdAndUserUsername(groceryId, username);
		try {
			groRepo.deleteById(toBeDeleted.getId());
			wasDeleted = true;
		} catch(Exception e) {
			e.printStackTrace();
			wasDeleted = false;
		}
		return wasDeleted;
	}

}
