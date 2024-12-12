package com.coforge.traning.shopstop.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.traning.shopstop.model.Order;
import com.coforge.traning.shopstop.model.Product;
import com.coforge.traning.shopstop.service.OrderService;
import com.coforge.traning.shopstop.service.ProductClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

/**
 *Author:Koppula.Reddy
 *date:Nov 29, 2024
 *time:3:15:44 PM
 *project:order-service

 **/
@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;

	//inject instance of feign client

	@Autowired
	private ProductClient productClient;

	@GetMapping("/orders/products")
	@CircuitBreaker(name = "productService" ,fallbackMethod = "getAllProductsFallBack")
	public ResponseEntity<List<Product>> getAll(){
		
		ResponseEntity<List<Product>> product=productClient.getAllProducts();

		if(product.getStatusCode()==HttpStatus.OK) {
			List<Product> p=product.getBody();
			return ResponseEntity.ok(p);
		}
		else {
			return ResponseEntity.status(product.getStatusCode()).body(null);
		}
	}

	public ResponseEntity<List<Product>> getAllProductsFallBack(Throwable thro){
		  // Log the error or take any necessary action
        System.err.println("Error occurred: " + thro.getMessage());
     // Create a placeholder Product with a message
        Product messageProduct = new Product();
        messageProduct.setName("Service Unavailable");
        messageProduct.setDescription("The Product Service is currently unavailable. Please try again later.");

        // Return a list containing the placeholder Product object
        List<Product> response = Collections.singletonList(messageProduct);

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
	}

	@PostMapping("/orders")
	@CircuitBreaker(name = "productService" ,fallbackMethod = "createorderFallBack")
	public ResponseEntity<Order> createorder(@RequestBody Order myorder){
		try {
			//interservice communication .using feign client we call getproductbyid() of product-service
			ResponseEntity<Product> product=productClient.getProductById(myorder.getProductId());

			//System.out.println("hello"+producttostring());
			if(product.getStatusCode()== HttpStatus.OK) {
				Product p=product.getBody();

				if(p==null) {
					return ResponseEntity.notFound().build();
				}

				//System.out.println("hello1"+p.tostring());
				myorder.setTotalPrice(p.getPrice()*myorder.getQuantity());//price & product from product-ms
				Order saveOrder=orderService.saveOrder(myorder);
				return ResponseEntity.status(HttpStatus.CREATED).body(saveOrder);
			}
			else {
				return ResponseEntity.status(product.getStatusCode()).build();
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	//Fall back method
	public ResponseEntity<Order> createorderFallBack(Order order,Throwable t) {
		
		 System.out.println("Fallback executed due to: " + t.getMessage());
		    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
		                         .body(null); // Customize the response as needed
	}


	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		try {
			List<Order> orders = orderService.getAllOrders();
			if (orders.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(orders);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
