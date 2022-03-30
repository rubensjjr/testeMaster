package com.example.api.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.loader.plan.exec.process.internal.AbstractRowReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.domain.Cidade;
import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;
import com.example.api.dto.CustomerNewDTO;
import com.example.api.exceptions.DataIntegrityException;
import com.example.api.repository.CustomerRepository;
import com.example.api.repository.EnderecoRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;


	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public List<Customer> findAll() {
		return repository.findAllByOrderByNameAsc();
	}

	public Optional<Customer> findById(Integer id) {
		return repository.findById(id);
	}

	// Inserindo o objeto novo Customer
	@Transactional // salva o cliente e o endereço na mesma transação no banco
	public Customer insert(Customer obj) {
		obj.setId(null); // ao inserir o objeto, ele garante obj nulo
		obj = repository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Customer update(Customer obj) {
		//findById(obj.getId());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);// verifica de existe antes de deletar
		try {
			repository.deleteById(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Não é possivel deletar um Customer que possui endereços cadastrados", e);
		}
	}
	
	public Customer fromDTO(CustomerNewDTO objDto) {
		Customer customer = new Customer(null, objDto.getName(),objDto.getEmail());
		Cidade cida = new Cidade(objDto.getCidadeId(), null , null);
		Endereco endereco = new Endereco(null, objDto.getLogradouro(),objDto.getNumero(),objDto.getComplemento(),objDto.getBairro(),objDto.getCep(), customer,cida);
		customer.getEnderecos().add(endereco);
		
		return customer;
	}

}
