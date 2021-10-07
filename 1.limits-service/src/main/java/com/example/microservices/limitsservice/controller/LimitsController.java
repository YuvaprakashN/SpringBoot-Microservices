package com.example.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.limitsservice.bean.Limits;
import com.example.microservices.limitsservice.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;

	
	@GetMapping("/limits")
	public Limits retriveLimits() {
		return(new Limits(1, 5));
	}
	
	@GetMapping("/config-limits")
	public Limits retriveConfigurationLimits() {
		
		//return new Limits(configuration.getMaximum(),configuration.getMinimum());
		
		//return new Limits(configuration.getMinimum(), 
			//	configuration.getMaximum());
		
		return new Limits(configuration.getMinimum(),configuration.getMaximum());
	}
	
}
