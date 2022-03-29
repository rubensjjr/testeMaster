package com.example.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.api.repository.CustomerRepository;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private CustomerRepository custumerRepository;

}
