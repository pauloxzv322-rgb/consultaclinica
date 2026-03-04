package com.projeto.consultaclinica; 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * O 'scanBasePackages' força o Spring a subir um nível e escanear 
 * as pastas 'controller', 'model' e 'service' que estão fora da pasta 'ui'.
 */
@SpringBootApplication(scanBasePackages = "com.projeto.consultaclinica")
public class ConsultaclinicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultaclinicaApplication.class, args);
    }

}