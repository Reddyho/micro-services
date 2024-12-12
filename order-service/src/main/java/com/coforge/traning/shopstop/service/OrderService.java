package com.coforge.traning.shopstop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.traning.shopstop.model.Order;
import com.coforge.traning.shopstop.repositoty.OrderRepository;

/**
*Author:Koppula.Reddy
*date:Nov 29, 2024
*time:3:13:48 PM
*project:order-service

**/

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo; 
	
	public Order saveOrder(Order myOrder) {
		return orderRepo.save(myOrder); 
	}
	
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}

}
