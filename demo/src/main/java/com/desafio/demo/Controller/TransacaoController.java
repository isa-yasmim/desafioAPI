package com.desafio.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.demo.model.Conta;
import com.desafio.demo.model.Transacao;
import com.desafio.demo.service.ContaService;
import com.desafio.demo.service.TransacaoService;

@RestController
@RequestMapping("/api/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private ContaService contaService;

    @GetMapping("/extrato/{idConta}")
    public List<Transacao> extrato(@PathVariable Long idConta){
        return transacaoService.extrato(idConta);
    }

    @GetMapping("extratoPeriodo/{idConta}")
    public List<Transacao> extratoPeriodo(@PathVariable Long idConta, @RequestParam LocalDate inicio, @RequestParam LocalDate fim) {
        return transacaoService.extratoPeriodo(idConta, inicio, fim);
    }

    @PostMapping("/deposito/{idConta}")
    public ResponseEntity<Transacao> deposito(@PathVariable Long idConta, @RequestBody BigDecimal valor) {
            Conta conta = contaService.getConta(idConta);
            Transacao transacao = transacaoService.deposito(valor, conta);
            return ResponseEntity.ok(transacao);
    }

    @PostMapping("/saque/{idConta}")
    public ResponseEntity<Transacao> saque(@PathVariable Long idConta, @RequestBody BigDecimal valor) {
            Conta conta = contaService.getConta(idConta);
            Transacao transacao = transacaoService.saque(valor, conta);
            return ResponseEntity.ok(transacao);
        
    }
}
