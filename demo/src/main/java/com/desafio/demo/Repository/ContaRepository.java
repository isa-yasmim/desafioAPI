package com.desafio.demo.repository;

//import java.util.List;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.demo.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    List<Conta> findByPessoaIdPessoa(Long idPessoa); //Uma pessoa pode ter mais de uma conta
}
