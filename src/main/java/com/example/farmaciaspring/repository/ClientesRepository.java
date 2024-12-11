package com.example.farmaciaspring.repository;

import com.example.farmaciaspring.model.Cliente;
import com.example.farmaciaspring.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
    // Aquí puedes añadir métodos personalizados si es necesario
}
