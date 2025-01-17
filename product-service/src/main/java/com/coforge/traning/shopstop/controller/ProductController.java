package com.coforge.traning.shopstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.traning.shopstop.Exception.ResourseNotFoundException;
import com.coforge.traning.shopstop.model.Product;
import com.coforge.traning.shopstop.service.ProductService;

/**
*Author:Koppula.Reddy
*date:Nov 29, 2024
*time:1:11:00 PM
*project:product-service

**/
@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	//http://localhost:8081/api/products
		@PostMapping("/products")
		public ResponseEntity<Product> saveProduct(@Validated @RequestBody Product product){
			try {
				Product p= pservice.saveProduct(product);   //Invokes method in service layer
				return ResponseEntity.status(HttpStatus.CREATED).body(p);
			}
			catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}

		@GetMapping("/products")
		public ResponseEntity<List<Product>> getAllProducts(){
			try {
				List<Product> products=pservice.listAll();
				return ResponseEntity.ok(products);
			}
			catch(Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}
		
		@GetMapping("/products/{pid}")
		public ResponseEntity<Product> getProductById(@PathVariable(value="pid") Long pId) 
				throws ResourseNotFoundException{

			Product p=pservice.getSingleProduct(pId).orElseThrow(() ->
			new  ResourseNotFoundException("Product Not Found for this Id : "+pId));

			return ResponseEntity.ok(p);
		}
		
		@Autowired
		Environment environment;
		
		@GetMapping("/products/hello")
		public String hello() {
			return "Hello 3shul from product-microservice by honey 💛🚲💛" + environment.getProperty("local.server.port");
		}


}
