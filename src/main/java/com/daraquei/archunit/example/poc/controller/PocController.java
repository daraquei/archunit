package com.daraquei.archunit.example.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daraquei.archunit.example.poc.service.PocServiceImpl;

@RestController
public class PocController {
	
	@Autowired
	public PocServiceImpl pocServiceImpl;
	
	@GetMapping(value = "/ping")
	public String ping() {
		return pocServiceImpl.ping();
	}

}
