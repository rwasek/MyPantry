package com.richardwasek.mypantry.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richardwasek.mypantry.entities.Grocery;
import com.richardwasek.mypantry.services.GroceryService;

@RestController
@RequestMapping(path="api")
public class GroceryController {
	
	@Autowired
	GroceryService groSvc;
	private String username = "rwasek";
	
	@GetMapping("groceries")
	public Set<Grocery> index(String username){
		return groSvc.index(this.username);
	}

}
