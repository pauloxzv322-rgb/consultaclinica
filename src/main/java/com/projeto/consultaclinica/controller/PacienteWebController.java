package com.projeto.consultaclinica.controller;

import com.projeto.consultaclinica.model.Paciente;
import com.projeto.consultaclinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pacientes") // Endereço base: /pacientes
public class PacienteWebController {

    @Autowired
    private PacienteRepository repository;

    // LISTAR: http://localhost:8086/pacientes
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", repository.findAll());
        return "lista-pacientes";
    }

    // FORMULÁRIO: http://localhost:8086/pacientes/novo
    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("paciente", new Paciente()); 
        return "cadastro";
    }

    // SALVAR: http://localhost:8086/pacientes/salvar
    @PostMapping("/salvar")
    public String salvarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        repository.save(paciente);
        // Redireciona para /pacientes (o método listar acima)
        return "redirect:/pacientes"; 
    }

    // EXCLUIR: http://localhost:8086/pacientes/excluir/{id}
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/pacientes";
    }
}