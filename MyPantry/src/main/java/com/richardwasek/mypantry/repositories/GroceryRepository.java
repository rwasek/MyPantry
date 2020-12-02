package com.richardwasek.mypantry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.richardwasek.mypantry.entities.Grocery;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer> {

}
