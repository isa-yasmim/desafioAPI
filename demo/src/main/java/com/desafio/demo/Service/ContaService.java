package com.desafio.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.desafio.demo.model.Conta;

public interface ContaService {

    public Conta criarConta(Conta conta);

    public BigDecimal verSaldo(Long idConta);

    public Conta bloquearConta(Long idConta);

    public Conta getConta(Long idConta);

    public List<Conta> getContaByPessoa(Long idPessoa);

    public Optional<Conta> findById(Long idConta);

    public List<Conta> findAll();
}
