package com.coforge.taraning.shopstop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
*Author:Koppula.Reddy
*date:Nov 29, 2024
*time:11:50:48 AM
*project:payment-service
*
*CartRestConsumer and discover Service Instance of Cart Service to 
* communicate and get data. 
* In order to do this, we will take help of DiscoveryClient.

**/
@Component
public class CartRestConsumer {
	
	@Autowired
	private DiscoveryClient client;
	//get service instance list using service id
	public String getCartInfo() {
		List<ServiceInstance> siList=client.getInstances("CART-SERVICE");
		
		//read manalluy one istance from index#0
		ServiceInstance si=siList.get(0);
		
		//read uri and add path return url
		String url=si.getUri()+"/cart/getCartData";
		
		//create object for rest templete
		//REST client -consuming web api/rest-api
		RestTemplate rt=new RestTemplate();
		
		//make HTTP call and get response data
		String response=rt.getForObject(url,String.class);
		
		//return response back to consumer
		return response;
	}
}
