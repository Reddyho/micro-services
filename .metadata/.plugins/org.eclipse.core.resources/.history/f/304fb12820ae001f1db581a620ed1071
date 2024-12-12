package com.coforge.taraning.shopstop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.taraning.shopstop.service.CartRestConsumer;

/**
*Author:Koppula.Reddy
*date:Nov 29, 2024
*time:12:05:12 PM
*project:payment-service

**/

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private CartRestConsumer consumer;
	
	//Acess cart-service from Payment-Service
	
	//http://localhost:8989/payment/data
	@GetMapping("/data")
	public String getPaymentData() {
		return "FROM PAYMENT-SERVICE :"+consumer.getCartInfo();//consume cart-service
		
	}

}
