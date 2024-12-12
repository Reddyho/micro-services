package com.coforge.traning.shopstop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.traning.shopstop.model.Order;

/**
*Author:Koppula.Reddy
*date:Nov 29, 2024
*time:3:11:58 PM
*project:order-service

**/
public interface OrderRepository extends JpaRepository<Order, Long> {

}
