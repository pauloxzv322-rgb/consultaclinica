package com.projeto.consultaclinica.model;

import com.projeto.consultaclinica.ui.Menu; // Isso é para o Java achar o seu Menu

public class Teste {

    public static void main(String[] args) {
        // 1. Primeiro a mensagem de teste
        System.out.println("Pacotes e estrutura funcionando!");

        // 2. Depois chamamos o menu
        Menu menu = new Menu();
        
        // Se no seu arquivo Menu.java o método se chama "iniciar", use:
        menu.exibirMenu(); 
        
        // Se no seu arquivo Menu.java o método se chama "exibirMenu", use:
        // menu.exibirMenu();
    }
}