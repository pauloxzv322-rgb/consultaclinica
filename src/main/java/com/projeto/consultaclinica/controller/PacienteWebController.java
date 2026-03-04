package com.projeto.consultaclinica.controller;

import com.projeto.consultaclinica.model.Paciente;
import com.projeto.consultaclinica.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes")
public class PacienteWebController {

    private final PacienteRepository pacienteRepository;

    public PacienteWebController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    // LISTAR PACIENTES
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "lista-pacientes";
    }

    // FORMULÁRIO DE CADASTRO
    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "cadastro-paciente";
    }

    // SALVAR PACIENTE
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("paciente") Paciente paciente) {
        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }

    // EDITAR PACIENTE
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow();
        model.addAttribute("paciente", paciente);
        return "cadastro-paciente";
    }

    // EXCLUIR PACIENTE
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
        return "redirect:/pacientes";
    }
}