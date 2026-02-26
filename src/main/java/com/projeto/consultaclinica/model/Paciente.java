package com.projeto.consultaclinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "pacientes")
public class Paciente {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;

    // Construtor vazio: O Spring precisa dele para "montar" o objeto vindo do banco
    public Paciente() {
    }

    // Construtor que você já usava para facilitar o cadastro
    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Getters e Setters: O "tradutor" (JPA) usa eles para ler e escrever os dados
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | CPF: " + cpf;
    }
}