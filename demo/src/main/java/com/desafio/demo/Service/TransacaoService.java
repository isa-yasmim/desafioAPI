package com.desafio.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.desafio.demo.model.Conta;
import com.desafio.demo.model.Transacao;

public interface TransacaoService {
    public Transacao deposito(BigDecimal valor, Conta conta);

    public Transacao saque(BigDecimal valor, Conta conta);

    public List<Transacao> extrato(Long idConta);
}