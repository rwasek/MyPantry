package com.richardwasek.mypantry.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.richardwasek.mypantry.entities.Grocery;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {
	Grocery findByIdAndUserUsername(int groceryId, String username);
	Set<Grocery> findByUserUsername(String username);
	Set<Grocery> findByUserId(int id);
}
