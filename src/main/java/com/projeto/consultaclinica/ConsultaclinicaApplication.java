package com.projeto.consultaclinica;

import com.projeto.consultaclinica.ui.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsultaclinicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultaclinicaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(Menu menu) {
        return args -> {
            // Isso cria uma thread paralela para o menu não travar o console
            Thread threadMenu = new Thread(() -> {
                try {
                    menu.exibirMenu();
                } catch (Exception e) {
                    System.err.println("Erro ao carregar o menu.");
                }
            });
            threadMenu.start();
            
            System.out.println("\n[AVISO] Servidor ativo na porta 8081.");
            System.out.println("[AVISO] Acesse: http://localhost:8081/h2-console\n");
        };
    }
}