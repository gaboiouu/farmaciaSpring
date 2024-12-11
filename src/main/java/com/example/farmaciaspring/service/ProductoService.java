package com.example.farmaciaspring.service;

import com.example.farmaciaspring.model.Producto;
import com.example.farmaciaspring.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Buscar productos por nombre
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Buscar productos por categoría
    public List<Producto> buscarPorCategoria(String categoria) {
        return productoRepository.findByCategoriaContainingIgnoreCase(categoria);
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por su ID
    public Producto getProductoById(int id) {
        Optional<Producto> productoOpt = productoRepository.findById(id);
        return productoOpt.orElse(null); // Retorna null si no se encuentra
    }

    // Agregar un nuevo producto
    public Producto addProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto existente
    public Producto updateProducto(int id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setId(id); // Asegúrate de que el ID se mantenga
            return productoRepository.save(producto);
        }
        return null; // Retorna null si no se encuentra
    }

    // Eliminar un producto por su ID
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }
}
