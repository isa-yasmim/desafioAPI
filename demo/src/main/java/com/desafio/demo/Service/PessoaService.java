package com.desafio.demo.service;

import java.util.List;
import java.util.Optional;

import com.desafio.demo.model.Pessoa;

public interface PessoaService {

    public Pessoa criarPessoa(Pessoa pessoa);

    public List<Pessoa> findAll();

    public Pessoa getPessoaByCpf(String cpf);

    public Optional<Pessoa> findById(Long idPessoa);
}
