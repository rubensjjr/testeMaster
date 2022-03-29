package com.example.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;

public class CustomerDTOold implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty (message = "Preenchimento obrigatório")
	@Length(min = 5,max = 125, message = "O tamanho deve ser maior que 5 caracter")
	private String name;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email Invalido")
	private String email;
	private List<Endereco> enderecos = new ArrayList<>();

	public CustomerDTOold() {
	}
	public CustomerDTOold (Customer obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public List<Endereco> getEndereco() {
		return getEndereco();
	}
	public void setEndereco(List<Endereco> endereco) {
		this.enderecos = endereco;
	}
	

}
