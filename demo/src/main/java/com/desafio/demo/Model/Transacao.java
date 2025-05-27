package com.desafio.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TRANSACAO")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRANSACAO")
    @SequenceGenerator(name = "SEQ_TRANSACAO", sequenceName = "SEQ_TRANSACAO", allocationSize = 1)
    @Column(name = "IDTRANSACAO")
    private long idTransacao;

    @ManyToOne
    @JoinColumn(name = "IDCONTA", nullable = false)
    private Conta conta;

    @Column(name = "VALOR", precision = 15, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "DATATRANSACAO", nullable = false)
    private LocalDate dataTransacao;

    public long getIdTransacao() {
        return idTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public String getDataTransacaoFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataTransacao.format(formatter);
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
}
