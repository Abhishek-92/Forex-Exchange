package com.idfc.controller;

import com.idfc.service.CurrencyServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/getExchangeRate")
public class ApiController {
	
	@Autowired
	private CurrencyServiceImple service;
	
	@GetMapping("/{title}")
	public ResponseEntity<Object> getExchangeRate(@PathVariable String title){
		double res = this.service.getExchangeRate(title);
		if(res == -1)
			return new ResponseEntity<Object>("Exchange Rate not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
}
