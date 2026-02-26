package com.projeto.consultaclinica.repository;

import com.projeto.consultaclinica.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    // Aqui o Spring já nos entrega métodos prontos como:
    // .save(consulta), .findAll(), .deleteById(id)
}