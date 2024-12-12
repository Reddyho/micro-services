package com.coforge.traning.shopstop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.traning.shopstop.model.Product;
import com.coforge.traning.shopstop.repositery.ProductRepositery;

/**
*Author:Koppula.Reddy
*date:Nov 29, 2024
*time:1:04:56 PM
*project:product-service

**/
@Service
public class ProductService {
	
	   
	   @Autowired
		private ProductRepositery prepo;
		
		public Product saveProduct(Product p)
		{
			return prepo.save(p);  //Invokes pre-defined method save() of JPA repository
		}
		
		public List<Product> listAll(){
			return prepo.findAll();  //Invokes pre-defined method findAll() of JPA repository
		}
		
		// Optional return type is to handle Null Pointer Exception
	   public Optional<Product> getSingleProduct(long pid) {
		   return prepo.findById(pid);            //Invokes pre-defined method findById() of JPA repository
	   }

}
