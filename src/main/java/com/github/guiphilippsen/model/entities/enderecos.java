package com.github.guiphilippsen.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "enderecos")
public class enderecos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;



}
