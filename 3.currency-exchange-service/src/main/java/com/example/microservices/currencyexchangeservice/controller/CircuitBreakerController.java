package com.example.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CircuitBreakerController {

	
	private static final Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);

	
	@GetMapping("/sample-api")
	//@Retry(name="sample-api",fallbackMethod ="hardcodedResponse" )
	//@CircuitBreaker(name = "sample-api", fallbackMethod = "hardcodedResponse")
	//@RateLimiter(name="sample-api")
	@Bulkhead(name="sample-api")
	public String sampleApi() {
		log.info("Calling SAMPLE API");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", 
				String.class);
	return forEntity.getBody();
//		return "Sample API";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}
	
}
