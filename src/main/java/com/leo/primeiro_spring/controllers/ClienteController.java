package com.leo.primeiro_spring.controllers;

import com.leo.primeiro_spring.models.Cliente;
import com.leo.primeiro_spring.repositories.ClienteRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@SuppressWarnings("null")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    // Injeção via construtor (bom para testes e clareza)
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        // ao salvar, o id será gerado automaticamente pelo banco
        return repository.save(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente novo) {
        return repository.findById(id)
                .map(cliente -> {
                    cliente.setNome(novo.getNome());
                    cliente.setEmail(novo.getEmail());
                    Cliente atualizado = repository.save(cliente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> {
                    novo.setId(id);
                    Cliente criado = repository.save(novo);
                    return ResponseEntity.ok(criado);
                });
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

