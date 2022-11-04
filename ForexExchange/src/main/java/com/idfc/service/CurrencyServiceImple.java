package com.idfc.service;

import java.util.List;

import com.idfc.dao.CurrencyRepository;
import com.idfc.model.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImple implements CurrencyService {
	
	@Autowired
	private CurrencyRepository repo;

	@Override
	public Currency addCurrency(Currency currency) {
		// TODO Auto-generated method stub
		return this.repo.save(currency);
	}

	@Override
	public List<Currency> getCurrency() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Currency getCurrencyById(int id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}

	@Override
	public Currency editCurrency(int id, Currency currency) {
		// TODO Auto-generated method stub
		Currency res = this.repo.findById(id).get();
		res.setExchangeRate(currency.getExchangeRate());
		res.setTitle(currency.getTitle());
		return this.repo.save(res);
	}

	@Override
	public String deleteCurrency(int id) {
		// TODO Auto-generated method stub
		this.repo.deleteById(id);
		return "Currency deleted sucessfully";
	}

	@Override
	public double getExchangeRate(String title) {
		// TODO Auto-generated method stub
		List<Currency> res = this.repo.findAll();
		for( Currency curr : res) {
			if(curr.getTitle().equals(title)) {
				return curr.getExchangeRate();
			}
		}
		return -1;
	}

}
