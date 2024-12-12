package com.coforge.traning.shopstop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
 * Functionality: Manages order-related data and communicates with the product service 
 * using Feign. 
 * 
 *  Main class for Order Service.
 * This service manages orders and uses Feign to communicate with the Product Service.
 * It registers itself with Eureka for service discovery.
 * 
 * The @EnableFeignClients annotation is part of the Spring Cloud OpenFeign module, 
 * which allows you to easily create REST clients. It enables the auto-configuration of 
 * Feign clients for the beans annotated with @FeignClient or @FeignClients
 */

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
