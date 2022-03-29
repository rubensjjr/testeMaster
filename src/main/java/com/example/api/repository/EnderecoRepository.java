package com.example.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	//List<Endereco> findAllByOrderByNameAsc();

}
