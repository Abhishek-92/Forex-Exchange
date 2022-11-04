package com.idfc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrConvertServiceImple implements CurrConverterService {

	@Override
	public double getExRateInInr(String title) {
		// TODO Auto-generated method stub
		String URL = "http://localhost:8082/api/getExchangeRate/{title}";
		Map<String, String> map = new HashMap<>();
		map.put("title", title);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Double> res = restTemplate.getForEntity(URL, Double.class, map);
		return res.getBody();
	}

//	@Override
//	public double getTotalValue(double amount, String fromCurr) {
//		// TODO Auto-generated method stub
//		double exchangeRate = this.getExRateInInr(fromCurr);
//		return amount*exchangeRate;
//	}

	@Override
	public double convertCurrByTitle(double curr, String fromCurr, String toCurr) {
		// TODO Auto-generated method stub
//		💥 Example to convert 20 USD to AED
		
//		1.Getting Exchange Rate of fromCurr(i.e USD, AED, etc) to INR
//		---> 1USD = 82 INR
		double exchangeRateFromCurr = this.getExRateInInr(fromCurr);
		
//		2.Now converting the currencyValue(curr) from fromCurr(USD.. etc) --> INR
//		---> 20USD = 20 * 82 INR = 1640 INR
		double fromCurrToInr = curr * exchangeRateFromCurr;
		
//		3.Getting Exchange Rate of toCurr(i.e USD, AED, etc) to INR
//		---> 1 AED = 22 INR
		double exchangeRateToCurr = this.getExRateInInr(toCurr);
		
//		4.Final Step is to get the value from step2 i.e (1640 INR) and convert it to AED
//		---> 1 AED = 22 INR but for ? AED = 1640 INR
//		---> there for 1 INR = 1/22 AED
//		---> 1640 * (1/22) AED (Output)
		return (fromCurrToInr/exchangeRateToCurr);
	}
	
	

}
