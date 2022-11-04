package com.idfc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	
	private double exchangeRate;

	public Currency() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Currency(String title, double exchangeRate) {
		super();
		this.title = title;
		this.exchangeRate = exchangeRate;
	}

	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", title=" + title + ", exchangeRate=" + exchangeRate + "]";
	} 
	
	
}
