package com.desafio.demo.repository;

//import java.time.LocalDate;
//import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.demo.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
    List<Transacao> findByContaIdConta(Long idConta);
    //List<Transacao> findByIdContaAndDataTransacaoBetween(Conta conta, LocalDate inicio, LocalDate fim);
    @Query("SELECT SUM(t.valor) FROM Transacao t WHERE t.valor < 0 AND t.dataTransacao = :data")
    BigDecimal sumValorByDataTransacao(@Param("data") LocalDate data);
}