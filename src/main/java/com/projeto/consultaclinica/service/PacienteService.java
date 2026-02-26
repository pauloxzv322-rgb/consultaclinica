package com.projeto.consultaclinica.service;

import com.projeto.consultaclinica.model.Paciente;
import com.projeto.consultaclinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Diz ao Spring que esta classe cuida da lógica
public class PacienteService {

    @Autowired // "Injeção": O Spring entrega o repositório pronto aqui
    private PacienteRepository repository;

    public void cadastrar(Paciente p) {
        // Agora usamos o .save() do JPA. Ele faz o "INSERT INTO" no banco.
        repository.save(p);
        System.out.println("✅ Paciente salvo no Banco de Dados!");
    }

    public List<Paciente> listarTodos() {
        // O .findAll() busca todas as linhas da tabela automaticamente
        return repository.findAll();
    }

    public Paciente buscarPorCpf(String cpfBusca) {
        // O JPA é tão inteligente que poderíamos criar buscas automáticas,
        // mas por enquanto, vamos filtrar a lista que vem do banco:
        return repository.findAll().stream()
                .filter(p -> p.getCpf().equals(cpfBusca))
                .findFirst()
                .orElse(null);
    }
}