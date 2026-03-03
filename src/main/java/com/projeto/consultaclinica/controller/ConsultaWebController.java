package com.projeto.consultaclinica.controller;

import com.projeto.consultaclinica.model.Consulta;
import com.projeto.consultaclinica.repository.ConsultaRepository;
import com.projeto.consultaclinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaWebController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // Listar todas as consultas
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("consultas", consultaRepository.findAll());
        return "lista-consultas";
    }

    // Exibir formulário de agendamento
    @GetMapping("/nova")
    public String exibirFormulario(Model model) {
        // Criamos um objeto vazio para o Thymeleaf preencher
        Consulta consulta = new Consulta();
        model.addAttribute("consulta", consulta);
        
        // Buscamos todos os pacientes para o <select> do HTML
        model.addAttribute("pacientes", pacienteRepository.findAll());
        
        return "agendar-consulta";
    }

    // Salvar agendamento
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("consulta") Consulta consulta) {
        // O Spring vincula automaticamente o ID do paciente selecionado ao objeto Consulta
        consultaRepository.save(consulta);
        return "redirect:/consultas";
    } // <-- Chave que fecha o método salvar adicionada aqui

    // Método excluir agora fora do salvar e dentro da classe
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        consultaRepository.deleteById(id);
        return "redirect:/consultas";
    }
}