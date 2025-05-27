package com.desafio.demo.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.demo.model.Conta;
import com.desafio.demo.service.ContaService;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/add")
    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta) {

        Conta novaConta = contaService.criarConta(conta);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(conta.getIdConta())
                .toUri();

        return ResponseEntity.created(location).body(novaConta);
    }

    @GetMapping("/all")
    public List<Conta> getAll() {
        return contaService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Conta> getConta(@PathVariable Long id) {
        return contaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/pessoa/{idPessoa}")
    public List<Conta> getContasByPessoa(@PathVariable Long idPessoa) {
        return contaService.getContaByPessoa(idPessoa);
    }

    @GetMapping("/saldo/{id}")
    public ResponseEntity<BigDecimal> verSaldo(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(contaService.verSaldo(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/bloquear/{id}")
    public ResponseEntity<Conta> bloquearConta(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(contaService.bloquearConta(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
