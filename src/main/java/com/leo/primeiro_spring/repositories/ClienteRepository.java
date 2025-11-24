package com.leo.primeiro_spring.repositories;

import java.util.ArrayList;
import java.util.List;
import com.leo.primeiro_spring.models.Cliente;

import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> findAll() {
        return clientes;
    }

    public Cliente save(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }
}
