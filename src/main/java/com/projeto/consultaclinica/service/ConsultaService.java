package com.projeto.consultaclinica.service;

import com.projeto.consultaclinica.model.Consulta;
import com.projeto.consultaclinica.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired // O Spring entrega o ConsultaRepository pronto para usar
    private ConsultaRepository repository;

    public void agendar(Consulta c) {
        // Agora salvamos a consulta diretamente no banco H2
        repository.save(c);
        System.out.println("🗓️ Consulta gravada no banco de dados com sucesso!");
    }

    public void listarAgenda() {
        // Buscamos todas as consultas que estão na tabela
        List<Consulta> consultas = repository.findAll();
        
        if (consultas.isEmpty()) {
            System.out.println("📭 A agenda está vazia no banco.");
        } else {
            System.out.println("\n--- AGENDA DE CONSULTAS ---");
            consultas.forEach(System.out::println);
        }
    }
}