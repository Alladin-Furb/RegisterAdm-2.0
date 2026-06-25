package com.transporte.escolar.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private String matricula;

    private String cpf;

    private String telefone;

    private String endereco;

    private String email;

    private String rotaTransporte;

    private UUID cursoId;

    private String nomeCurso;

    private String faculdade;

    private boolean confirmouPresenca;

    public Aluno() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRotaTransporte() {
        return rotaTransporte;
    }

    public void setRotaTransporte(String rotaTransporte) {
        this.rotaTransporte = rotaTransporte;
    }

    public UUID getCursoId() {
        return cursoId;
    }

    public void setCursoId(UUID cursoId) {
        this.cursoId = cursoId;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }

    public boolean isConfirmouPresenca() {
        return confirmouPresenca;
    }

    public void setConfirmouPresenca(boolean confirmouPresenca) {
        this.confirmouPresenca = confirmouPresenca;
    }
}