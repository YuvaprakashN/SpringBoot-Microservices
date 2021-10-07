package com.example.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.example.microservices.currencyexchangeservice.repositary.CurrencyExchangeRepositary;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeRepositary currencyExchangeRepo; 
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		String port = environment.getProperty("local.server.port");
		CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);
		currencyExchange.setEnvironment("ENV_PORT:"+port);
		return currencyExchange;
		
	}
	
	
	
	
}
