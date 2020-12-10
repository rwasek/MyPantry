package com.richardwasek.mypantry.services;

import java.util.List;
import java.util.Set;

import com.richardwasek.mypantry.entities.Grocery;

public interface GroceryService {
	Set<Grocery> index(String username);
	Grocery showByIdAndUser(String username, int groceryId);
	Grocery createGrocery(int categoryId, String username, Grocery grocery);
	Grocery updateGrocery(int categoryId, String username, int groceryId, Grocery grocery);
	boolean deleteGrocery(String username, int groceryId);
}
