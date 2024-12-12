package com.coforge.traning.shopstop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*Author:Koppula.Reddy
*date:Nov 28, 2024
*time:5:16:44 PM
*project:cart-service

**/
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@GetMapping("/getCartData")
	public String helloWorld() {
		return "Hello World from Cart-MicroServices";
	}

}
