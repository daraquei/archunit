package com.daraquei.archunit.example.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daraquei.archunit.example.poc.repository.PocRepository;

@Service
public class PocServiceImpl  {
	
	@Autowired
	public PocRepository pocRepository;
	
	public String ping() {
		 return pocRepository.ping();
	}

}
