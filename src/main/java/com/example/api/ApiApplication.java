package com.example.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.api.domain.Cidade;
import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;
import com.example.api.domain.Estado;
import com.example.api.repository.CidadeRepository;
import com.example.api.repository.CustomerRepository;
import com.example.api.repository.EnderecoRepository;
import com.example.api.repository.EstadoRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Estado estado1 = new Estado(null, "São Paulo");
		Estado estado2 = new Estado(null, "Rio de Janeiro");

		Cidade cidade1 = new Cidade(null, "Santo André", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado1);
		Cidade cidade3 = new Cidade(null, "Rio de Janeiro", estado2);

		estado1.getCidades().addAll(Arrays.asList(cidade1, cidade2));
		estado2.getCidades().addAll(Arrays.asList(cidade3));

		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		Customer customer1 = new Customer(null, "Rubens Junior", "Rubens@email.com");
		
		Endereco endereco1 = new Endereco(null, "Rua Lituania", "86", "Casa 1", "Vila curuca", "09280260", customer1, cidade1);
		Endereco endereco2 = new Endereco(null, "Rua Vasco", "85", "Casa 5", "Vila sonia", "09280898", customer1, cidade3);
		
		customer1.getEnderecos().addAll(Arrays.asList(endereco1,endereco2));
		
		customerRepository.saveAll(Arrays.asList(customer1));
		enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2));

	}

}
