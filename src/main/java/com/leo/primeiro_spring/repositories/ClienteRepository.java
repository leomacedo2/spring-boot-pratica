package com.leo.primeiro_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leo.primeiro_spring.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // aqui você já tem: findAll, findById, save, deleteById, etc.
}
