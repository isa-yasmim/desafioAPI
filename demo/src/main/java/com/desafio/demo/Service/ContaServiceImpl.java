package com.desafio.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.demo.model.Conta;
import com.desafio.demo.model.Pessoa;
import com.desafio.demo.repository.ContaRepository;
import com.desafio.demo.repository.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository repoConta;

    @Autowired
    private PessoaRepository repoPessoa;

    @Override
    public Conta criarConta(Conta conta) {

        Pessoa pessoa = repoPessoa.findById(conta.getPessoa().getIdPessoa())
        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        
        conta.setFlagAtivo(1);
        conta.setDataCriacao(LocalDate.now());

        conta.setPessoa(pessoa);
        
        return repoConta.save(conta);
    }

    @Override
    public BigDecimal verSaldo(Long idConta) {
        Conta conta = repoConta.findById(idConta)
                .orElseThrow(() -> new IllegalArgumentException("Erro ao buscar conta"));
        return conta.getSaldo();
    }

    @Override
    public Conta bloquearConta(Long idConta) {
        Conta conta = repoConta.findById(idConta)
                .orElseThrow(() -> new IllegalArgumentException("Erro ao buscar conta"));
        conta.setFlagAtivo(0);
        return repoConta.save(conta);
    }

    @Override
    public Conta getConta(Long idConta) {
        return repoConta.findById(idConta)
                .orElseThrow(() -> new IllegalArgumentException("Erro ao buscar conta"));
    }

    @Override
    public List<Conta> getContaByPessoa(Long idPessoa) {
        return repoConta.findByPessoaIdPessoa(idPessoa);
    }

    @Override
    public Optional<Conta> findById(Long idConta) {
        return repoConta.findById(idConta);
    }

    @Override
    public List<Conta> findAll() {
        return repoConta.findAll();
    }
}
