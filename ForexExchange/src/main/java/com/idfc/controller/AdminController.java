package com.idfc.controller;

import com.idfc.model.Currency;
import com.idfc.service.CurrencyServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class AdminController {

	@Autowired
	private CurrencyServiceImple service;
	
	@PostMapping("/")
	public ResponseEntity<Object> insertCurrency(@RequestBody Currency currency){
		Currency res = this.service.addCurrency(currency);
		if(res == null) {
			return new ResponseEntity<Object>("Currency not added", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>("Currency added sucessfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> getAllCurrency(){
		return new ResponseEntity<Object>(this.service.getCurrency(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCurrency(@PathVariable int id){
		return new ResponseEntity<Object>(this.service.deleteCurrency(id), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCurrencyById(@PathVariable int id){
		Currency res = this.service.getCurrencyById(id);
		if(res == null) {
			return new ResponseEntity<Object>("Currency not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Object> editCurrencyById(@PathVariable int id, @RequestBody Currency currency){
		Currency res = this.service.editCurrency(id, currency);
		if(res == null) {
			return new ResponseEntity<Object>("Currency not updated", HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Object>("Currency update Sucessfully", HttpStatus.OK);
	}
	
}
