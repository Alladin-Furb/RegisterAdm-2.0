package com.transporte.escolar.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @Column(unique = true)
    private String carteiraMotorista;

    public Motorista() {
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCarteiraMotorista() {
        return carteiraMotorista;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarteiraMotorista(String carteiraMotorista) {
        this.carteiraMotorista = carteiraMotorista;
    }
}