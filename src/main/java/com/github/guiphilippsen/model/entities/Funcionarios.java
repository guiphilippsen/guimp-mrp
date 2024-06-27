package com.github.guiphilippsen.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "funcionarios")
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "datacontratacao")
    private Date dataContratacao;

    public Funcionarios() {}
    public Funcionarios(int id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    public Funcionarios(int id, String nome, String cargo, Date dataContratacao) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    public Funcionarios(int id, String nome, String password, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}
