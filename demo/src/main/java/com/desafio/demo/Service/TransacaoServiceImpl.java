package com.desafio.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.demo.model.Conta;
import com.desafio.demo.model.Transacao;
import com.desafio.demo.repository.TransacaoRepository;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoRepository repoTransacao;

    @Override
    public Transacao deposito(BigDecimal valor, Conta conta) {

        if (conta.getFlagAtivo() != 1) {
            throw new IllegalStateException("Conta desativada");
        }

        BigDecimal saldoFinal = conta.getSaldo().add(valor);
        conta.setSaldo(saldoFinal);

        Transacao newTransacao = new Transacao();

        newTransacao.setConta(conta);
        newTransacao.setDataTransacao(LocalDate.now());
        newTransacao.setValor(valor);

        return repoTransacao.save(newTransacao);
    }

    @Override
    public Transacao saque(BigDecimal valor, Conta conta) {
        if (conta.getFlagAtivo() != 1) {
            throw new IllegalStateException("Conta desativada");
        }
        
        BigDecimal saqueDiario = repoTransacao.sumValorByDataTransacao(LocalDate.now());
        if (saqueDiario == null) {
            saqueDiario = BigDecimal.ZERO;
        }
        else {
            saqueDiario = saqueDiario.multiply(new BigDecimal(-1));
        }

        BigDecimal limiteDisponivel = conta.getLimiteSaqueDiario().subtract(saqueDiario);

        if (valor.compareTo(limiteDisponivel) == 1) {
            throw new IllegalStateException("Passou do limite");
        }

        if (valor.compareTo(conta.getSaldo()) == 1) {
            throw new IllegalStateException("Saldo insuficiente");
        }

        BigDecimal saldoFinal = conta.getSaldo().subtract(valor);
        conta.setSaldo(saldoFinal);

        valor = valor.multiply(new BigDecimal(-1));

        Transacao newTransacao = new Transacao();

        newTransacao.setConta(conta);
        newTransacao.setDataTransacao(LocalDate.now());
        newTransacao.setValor(valor);

        return repoTransacao.save(newTransacao);
    }

    @Override
    public List<Transacao> extrato(Long idConta) {
        return repoTransacao.findByContaIdConta(idConta);
    }
}
