package com.projeto.consultaclinica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Relacionamento: Várias consultas para um Paciente
    private Paciente paciente;

    private LocalDateTime dataHora;

    // Construtor vazio obrigatório para o JPA
    public Consulta() {
    }

    public Consulta(Paciente paciente, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "ID: " + id + " | Paciente: " + paciente.getNome() + " | Data: " + dataHora.format(formato);
    }
}