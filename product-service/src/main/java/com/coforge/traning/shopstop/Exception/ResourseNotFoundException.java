package com.coforge.traning.shopstop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
*Author:Koppula.Reddy
*date:Nov 29, 2024
*time:1:07:36 PM
*project:product-service

**/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourseNotFoundException(String message) {
		super(message);

	}
	
	
	

}
