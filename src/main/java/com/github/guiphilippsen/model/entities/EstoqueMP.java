package com.github.guiphilippsen.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "estoquemp")
public class EstoqueMP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "nome")
    private String nome;

    @Column(name = "qtdestoque")
    private Double qtdestoque;

    @Column(name = "lote")
    private Long lote;

    @Column(name = "fornecedor")
    private String fornecedor;

    @Column(name = "datarecebimento")
    private Date datarecebimento;

    public EstoqueMP(Long id, String nome, Double qtdestoque, Long lote, String fornecedor, Date datarecebimento) {
        this.id = id;
        this.nome = nome;
        this.qtdestoque = qtdestoque;
        this.lote = lote;
        this.fornecedor = fornecedor;
        this.datarecebimento = datarecebimento;
    }

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

    public Double getQtdestoque() {
        return qtdestoque;
    }

    public void setQtdestoque(Double qtdestoque) {
        this.qtdestoque = qtdestoque;
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
