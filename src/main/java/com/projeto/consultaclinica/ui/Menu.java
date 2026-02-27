package com.projeto.consultaclinica.ui;

import com.projeto.consultaclinica.model.Paciente;
import com.projeto.consultaclinica.model.Consulta;
import com.projeto.consultaclinica.service.PacienteService;
import com.projeto.consultaclinica.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Component // teste Diz ao Spring que esta classe faz parte do projeto
public class Menu {

    @Autowired
    private PacienteService service;
    
    @Autowired
    private ConsultaService consultaService;

    private Scanner leitor = new Scanner(System.in);

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- SISTEMA DA CLÍNICA (MODO BANCO DE DADOS) ---");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Listar Pacientes");
            System.out.println("3 - Agendar Consulta");
            System.out.println("4 - Ver Agenda");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            
            opcao = leitor.nextInt();
            leitor.nextLine(); 

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = leitor.nextLine();
                System.out.print("CPF: ");
                String cpf = leitor.nextLine();
                service.cadastrar(new Paciente(nome, cpf));

            } else if (opcao == 2) {
                // Como o service agora retorna uma lista, o menu imprime:
                List<Paciente> pacientes = service.listarTodos();
                if (pacientes.isEmpty()) {
                    System.out.println("Nenhum paciente no banco.");
                } else {
                    pacientes.forEach(System.out::println);
                }

            } else if (opcao == 3) {
                System.out.print("CPF do paciente: ");
                String cpf = leitor.nextLine();
                Paciente p = service.buscarPorCpf(cpf);

                if (p != null) {
                    System.out.print("Data (dd/MM/yyyy HH:mm): ");
                    String dataStr = leitor.nextLine();
                    DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                    LocalDateTime data = LocalDateTime.parse(dataStr, parser);
                    
                    consultaService.agendar(new Consulta(p, data));
                } else {
                    System.out.println("❌ Paciente não encontrado!");
                }
            } else if (opcao == 4) {
                consultaService.listarAgenda();
            }
        }
    }
}