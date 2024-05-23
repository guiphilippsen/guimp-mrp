package com.github.guiphilippsen.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "estoquepf")
public class EstoquePF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "qtdestoque")
    private Double qtdestoque;

    @Column(name = "lote")
    private Long lote;

    @OneToOne
    @JoinColumn(name = "idusrprod")
    private Funcionarios funcionarios;

    public EstoquePF(Long id, String nome, Double qtdestoque, Long lote, Funcionarios funcionarios) {
        this.id = id;
        this.nome = nome;
        this.qtdestoque = qtdestoque;
        this.lote = lote;
        this.funcionarios = funcionarios;
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

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }
}
