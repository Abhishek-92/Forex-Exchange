package com.idfc.controller;

import com.idfc.service.CurrConvertServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api2")
public class ConverterController {

	@Autowired
	private CurrConvertServiceImple service;
	
	
	@GetMapping("/currConvert")
	public ResponseEntity<Object> currConvert(
			@RequestParam double curr, 
			@RequestParam String fromCurr, 
			@RequestParam String toCurr
			){
		System.out.println("in here");
		double res = this.service.convertCurrByTitle(curr, fromCurr, toCurr);
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
	
	
//	@GetMapping("/currConvert")
//	public ResponseEntity<Object> currConvert(
//			@RequestParam double curr, 
//			@RequestParam String fromCurr
//			){
//
//		double totalAmount = this.service.getTotalValue(curr, fromCurr);
//		return new ResponseEntity<Object>(totalAmount, HttpStatus.OK);
//	}
}
