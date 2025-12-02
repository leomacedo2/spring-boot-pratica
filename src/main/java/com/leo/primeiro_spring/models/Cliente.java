package com.leo.primeiro_spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Cliente {

    // Identificador único do cliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Validação de nome
    @NotBlank(message = "O nome não pode ser vazio")
    private String nome;

    // Validação de email
    @Email(message = "Email inválido")
    @NotBlank(message = "O email não pode ser vazio")
    private String email;

    // Construtor padrão (necessário para o JPA)
    public Cliente() {}

    // Construtor útil para testes
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // getters e setters
    public Long getId() {
        return id;
    }

    // sem setter para id caso queira travar; mas você pode manter
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
