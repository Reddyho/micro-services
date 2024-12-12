package com.coforge.traning.shopstop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*
 * Functionality: Manages product-related data using JPA and MySQL. 
 * Registers itself with Eureka for service discovery.
 * 
 *  Main class for Product Service.
 * 
 * Confirm it’s registered in Eureka by checking the dashboard.
 * Access the product service API via http://localhost:8081/products.
 * 
 *  The @EnabledDiscoveryClient annotation is used to enable this feature, which allows your 
 *  application to register and discover other services within your Spring Cloud architecture.
 */

@EnableDiscoveryClient
@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
