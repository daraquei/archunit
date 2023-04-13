package com.daraquei.archunit.example.poc.repository;

import org.springframework.stereotype.Component;

@Component
public class PocRepository {
	
	public String ping() {
		 return "service is up";
	}

}
