package com.contas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empresa;
    private String nome;
    private String cnpj;
    private int porcentagem_taxa;
    private BigDecimal saldo;

    @OneToMany(mappedBy = "empresa")
    private List<Cliente> clientes;

    public Empresa() {
    }

    public Empresa(Long id_empresa, String nome, String cnpj, int porcentagem_taxa, BigDecimal saldo) {
        this.id_empresa = id_empresa;
        this.nome = nome;
        this.cnpj = cnpj;
        this.porcentagem_taxa = porcentagem_taxa;
        this.saldo = saldo;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getPorcentagem_taxa() {
        return porcentagem_taxa;
    }

    public void setPorcentagem_taxa(int porcentagem_taxa) {
        this.porcentagem_taxa = porcentagem_taxa;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa empresa)) return false;
        return Objects.equals(getId_empresa(), empresa.getId_empresa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_empresa());
    }
}
