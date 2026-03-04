package com.projeto.consultaclinica.controller;

import com.projeto.consultaclinica.model.Consulta;
import com.projeto.consultaclinica.repository.ConsultaRepository;
import com.projeto.consultaclinica.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConsultaWebController {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;

    public ConsultaWebController(ConsultaRepository consultaRepository,
                                 PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    // Rota para a Página Inicial (index.html que está em static)
    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }

    // Listagem de Consultas
    @GetMapping("/consultas")
    public String listar(Model model) {
        model.addAttribute("consultas", consultaRepository.findAll());
        return "lista-consultas";
    }

    // Atalho caso você digite /lista no navegador
    @GetMapping("/lista")
    public String listarAlias() {
        return "redirect:/consultas";
    }

    // Formulário de Agendamento
    @GetMapping("/consultas/nova")
    public String exibirFormulario(Model model) {
        model.addAttribute("consulta", new Consulta());
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "agendar-consulta";
    }

    @PostMapping("/consultas/salvar")
    public String salvar(@ModelAttribute("consulta") Consulta consulta) {
        consultaRepository.save(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/consultas/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        consultaRepository.deleteById(id);
        return "redirect:/consultas";
    }
}