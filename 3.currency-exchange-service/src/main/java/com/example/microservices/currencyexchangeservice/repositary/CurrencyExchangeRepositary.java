package com.example.microservices.currencyexchangeservice.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microservices.currencyexchangeservice.model.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepositary extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from,String to);
}
