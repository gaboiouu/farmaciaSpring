package com.example.farmaciaspring.service;

import com.example.farmaciaspring.model.Cliente;
import com.example.farmaciaspring.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;


    // Obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clientesRepository.findAll();
    }

    // Obtener un cliente por su ID
    public Cliente getClienteById(int id) {
        Optional<Cliente> clienteOpt = clientesRepository.findById(id);
        return clienteOpt.orElse(null); // Retorna null si no se encuentra
    }

    // Agregar un nuevo cliente
    public Cliente addCliente(Cliente cliente) {
        return clientesRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente updateCliente(int id, Cliente cliente) {
        if (clientesRepository.existsById(id)) {
            cliente.setId(id); // Asegúrate de que el ID se mantenga
            return clientesRepository.save(cliente);
        }
        return null; // Retorna null si no se encuentra
    }

    // Eliminar un cliente por su ID
    public void deleteCliente(int id) {
        clientesRepository.deleteById(id);
    }
}
