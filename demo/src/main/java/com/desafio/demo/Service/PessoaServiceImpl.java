package com.desafio.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.demo.model.Pessoa;
import com.desafio.demo.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository repoPessoa;

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        if (repoPessoa.existsByCpf(pessoa.getCpf())) {
            throw new IllegalArgumentException("CPF ja foi registrado");
        }

        Pessoa newPessoa = new Pessoa();
        newPessoa.setNome(pessoa.getNome());
        newPessoa.setCpf(pessoa.getCpf());
        newPessoa.setDataNascimento(pessoa.getDataNascimento());

        return repoPessoa.save(newPessoa);
    }

    @Override
    public Pessoa getPessoaByCpf(String cpf) {
        return repoPessoa.findByCpf(cpf);
    }

    @Override
    public Optional<Pessoa> findById(Long idPessoa) {
        return repoPessoa.findById(idPessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        return repoPessoa.findAll();
    }
}
