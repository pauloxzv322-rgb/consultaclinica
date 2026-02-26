package com.projeto.consultaclinica.repository;

import com.projeto.consultaclinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // O Spring Boot vai criar automaticamente métodos como:
    // .save(), .findAll(), .findById(), .delete()
}