package com.idfc.service;

public interface CurrConverterService {
	
	public double getExRateInInr(String title);
	
	public double convertCurrByTitle(double curr, String fromCurr, String toCurr);
	
//	public double getTotalValue(double amount, String fromCurr);
	
}
