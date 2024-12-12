package com.coforge.traning.shopstop.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.traning.shopstop.model.Product;

/**
*Author:Koppula.Reddy
*date:Nov 29, 2024
*time:1:02:10 PM
*project:product-service

**/
public interface ProductRepositery extends JpaRepository<Product, Long>{

}
