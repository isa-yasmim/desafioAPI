package com.desafio.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.demo.model.Pessoa;
import com.desafio.demo.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/add")
    public ResponseEntity<Pessoa> add(@RequestBody Pessoa pessoa) {
        pessoaService.criarPessoa(pessoa);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoa.getIdPessoa())
                .toUri();

        return ResponseEntity.created(location).body(pessoa);
    }

    @GetMapping("/all")
    public List<Pessoa> getAll() {
        return pessoaService.findAll();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Pessoa> getPessoaByCpf(@PathVariable String cpf) {
        Pessoa pessoa = pessoaService.getPessoaByCpf(cpf);
        return ResponseEntity.ok(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable("id") Long idPessoa) {
        return pessoaService.findById(idPessoa)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
