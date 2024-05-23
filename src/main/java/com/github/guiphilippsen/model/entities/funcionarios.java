package com.github.guiphilippsen.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "funcionarios")

public class funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "nome")
    public String nome;
    @Column(name = "password")
    public String password;
    @Column(name = "cargo")
    public String cargo;
    @Column(name = "datacontratacao")
    public Date datacontratacao;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getDatacontratacao() {
        return datacontratacao;
    }

    public void setDatacontratacao(Date datacontratacao) {
        this.datacontratacao = datacontratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
