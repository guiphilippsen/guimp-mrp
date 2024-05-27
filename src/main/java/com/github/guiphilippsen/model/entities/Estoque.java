package com.github.guiphilippsen.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "qtdestoque")
    private Double qtdEstoque;

    @Column(name = "valor")
    private Double valor;

    public Estoque(){}
    public Estoque(Double qtdEstoque, Double valor) {
        this.qtdEstoque = qtdEstoque;
        this.valor = valor;
    }
    public Estoque(String nome, Double qtdEstoque, Double valor) {
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
