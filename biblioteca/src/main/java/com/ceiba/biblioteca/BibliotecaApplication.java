package com.ceiba.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.ceiba.biblioteca.components",
    "com.ceiba.biblioteca.config",
    "com.ceiba.biblioteca.constants",
    "com.ceiba.biblioteca.controllers",
    "com.ceiba.biblioteca.domain",
    "com.ceiba.biblioteca.dto",
    "com.ceiba.biblioteca.enums",
    "com.ceiba.biblioteca.exceptions",
    "com.ceiba.biblioteca.models",
    "com.ceiba.biblioteca.repositories",
    "com.ceiba.biblioteca.serializers",
    "com.ceiba.biblioteca.services",
})
@EnableJpaRepositories(basePackages = {
    "com.ceiba.biblioteca.repositories"})
@EntityScan(basePackages = "com.ceiba.biblioteca.models")
public class BibliotecaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

}
