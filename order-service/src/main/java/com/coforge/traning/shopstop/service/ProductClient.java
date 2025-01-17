package com.coforge.traning.shopstop.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.traning.shopstop.model.Product;

/**
*Author:Koppula.Reddy
*date:Nov 29, 2024
*time:3:21:36 PM
*project:order-service

**/

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductClient {
	

	/*
	 * When integrating with external APIs using Spring Boot, a popular choice is the Feign client.
	 *  Feign is a declarative web service client that simplifies the process of making HTTP 
	 *  requests. With Spring Boot, you can easily create a Feign client by annotating an 
	 *  interface with the @ FeignClient annotation. This annotation specifies the API 
	 *  endpoint's base URL and other settings. Feign automatically generates the client 
	 *  code for making requests, making it a convenient and efficient way to 
	 *  consume web services.
	 */
	
	//Declare a method to be called from product-service using FeignClient
	@GetMapping("api/products/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable(value="pid") Long pId);
	
	//Get product details from another ms
	@GetMapping("api/products")
	public ResponseEntity<List<Product>> getAllProducts();

}
