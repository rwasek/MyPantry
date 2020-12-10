package com.richardwasek.mypantry.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		// change all to principle
		return groSvc.index(this.username);
	}
	
	@GetMapping("groceries/{gId}")
	public Grocery show(@PathVariable int gId, HttpServletResponse res, /*Principle principle*/ String username) {
		Grocery grocery = groSvc.showByIdAndUser(this.username, gId);
		if (grocery == null) {
			res.setStatus(404); // if wrong Id, 404 no grocery with that id
		}
		return grocery;
	}
	
	@PostMapping("groceries")
	// fix
	public Grocery create(@RequestBody Grocery grocery,@PathVariable int categoryId, HttpServletResponse res, HttpServletRequest req, String username) {
		grocery = groSvc.createGrocery(categoryId, this.username, grocery);
		try {
			if (grocery == null) {
				res.setStatus(404);
			}
			else {
				res.setStatus(201);
				StringBuffer url = req.getRequestURL();
				res.setHeader("Location", url.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			grocery = null;
		}
		return grocery;
	}

}
