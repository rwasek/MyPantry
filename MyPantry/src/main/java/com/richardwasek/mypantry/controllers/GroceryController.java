package com.richardwasek.mypantry.controllers;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.richardwasek.mypantry.entities.Grocery;
import com.richardwasek.mypantry.services.GroceryService;

@RestController
@RequestMapping(path="api")
@CrossOrigin({"*", "http://localhost:4214"})
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
	
//	@PostMapping("groceries/{catId}")
//	public Grocery create(@RequestBody Grocery grocery, @PathVariable int catId, HttpServletResponse res, HttpServletRequest req, String username) {
//		grocery = groSvc.createGrocery(catId, this.username, grocery);
//		try {
//			if (grocery == null) {
//				res.setStatus(404);
//			}
//			else {
//				res.setStatus(201);
//				StringBuffer url = req.getRequestURL();
//				res.setHeader("Location", url.toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			res.setStatus(400);
//			grocery = null;
//		}
//		return grocery;
//	}
	
	@PostMapping("groceries")
	public Grocery create(@RequestBody Grocery grocery, HttpServletResponse res, HttpServletRequest req, String username) {
		grocery = groSvc.createGrocery(this.username, grocery);
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
	
	@PutMapping("groceries/{groceryId}")
	public Grocery update(HttpServletRequest req, HttpServletResponse res, @PathVariable int groceryId, @RequestBody Grocery grocery, String username) {
		try {
			grocery = groSvc.updateGrocery(this.username, groceryId, grocery);
			if (grocery == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(404);
			grocery = null;
		}
		return grocery;
	}
	
	@DeleteMapping("groceries/{groceryId}")
	public void delete(HttpServletRequest req, HttpServletResponse res, @PathVariable int groceryId, String username) {
		try {
			boolean deleted = false;
			deleted = groSvc.deleteGrocery(this.username, groceryId);
			if (deleted == true) {
				res.setStatus(204); // 204 No content - Success
			}
			else {
				res.setStatus(404); // invalid ID, grocery not found
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400); // Error - bad request
		}
	}

}










