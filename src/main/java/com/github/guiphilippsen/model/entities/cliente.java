package com.github.guiphilippsen.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nome")
    public String nome;

    @Column(name = "contato")
    public String contato;
    
    @Column(name = "endereco")
    public String endereco;

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

}
