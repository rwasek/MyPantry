package com.richardwasek.mypantry.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class UserController {
	
	@GetMapping("ping")
	public String pong() {
		return "pong";
	}

}
