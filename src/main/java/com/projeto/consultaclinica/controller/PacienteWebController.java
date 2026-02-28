package com.projeto.consultaclinica.controller;

import com.projeto.consultaclinica.model.Paciente;
import com.projeto.consultaclinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PacienteWebController {

    @Autowired
    private PacienteRepository repository;

    // LISTAR: Busca todos os pacientes e envia para a página 'lista-pacientes'
    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("pacientes", repository.findAll());
        return "lista-pacientes";
    }

    // FORMULÁRIO: Cria um novo objeto Paciente e o envia para o formulário 'cadastro'
    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("paciente", new Paciente()); // Garante que o Thymeleaf encontre o objeto
        return "cadastro";
    }

    // SALVAR: Recebe o objeto preenchido no HTML e salva no banco de dados
    @PostMapping("/salvar")
    public String salvarPaciente(@ModelAttribute("paciente") Paciente paciente) {
        repository.save(paciente);
        return "redirect:/lista"; // Redireciona para atualizar a lista automaticamente
    }

    // EXCLUIR: Deleta pelo ID e recarrega a página de listagem
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/lista";
    }
}