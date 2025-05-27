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
@Table(name = "TB_CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTA")
    @SequenceGenerator(name = "SEQ_CONTA", sequenceName = "SEQ_CONTA", allocationSize = 1)
    @Column(name = "IDCONTA")
    private long idConta;

    @ManyToOne
    @JoinColumn(name = "IDPESSOA", nullable = false)
    private Pessoa pessoa;

    @Column(name = "SALDO", precision = 15, scale = 2, nullable = false)
    private BigDecimal saldo;

    @Column(name = "LIMITESAQUEDIARIO", precision = 15, scale = 2, nullable = false)
    private BigDecimal limiteSaqueDiario;

    @Column(name = "FLAGATIVO", nullable = false) //1-ativa 0-desativada
    private int flagAtivo;

    @Column(name = "TIPOCONTA", nullable = false) //1-corrente 2-salario 3-poupanca
    private int tipoConta;

    @Column(name = "DATACRIACAO", nullable = false)
    private LocalDate dataCriacao;

    public long getIdConta() {
        return idConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getLimiteSaqueDiario() {
        return limiteSaqueDiario;
    }

    public void setLimiteSaqueDiario(BigDecimal limiteSaqueDiario) {
        this.limiteSaqueDiario = limiteSaqueDiario;
    }

    public int getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(int flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public int getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(int tipoConta) {
        this.tipoConta = tipoConta;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getDataCriacaoFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataCriacao.format(formatter);
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
