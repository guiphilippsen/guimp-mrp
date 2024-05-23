package com.github.guiphilippsen.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "estoquemp")
public class estoquemp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "qtdestoque")
    public Double qtdestoque;

    @Column(name = "lote")
    public Long lote;

    @Column(name = "fornecedor")
    public String fornecedor;

    @Column(name = "datarecebimento")
    public Date datarecebimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getLote() {
        return lote;
    }

    public void setLote(Long lote) {
        this.lote = lote;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getDatarecebimento() {
        return datarecebimento;
    }

    public void setDatarecebimento(Date datarecebimento) {
        this.datarecebimento = datarecebimento;
    }
}
