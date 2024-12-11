package com.example.farmaciaspring.service;

import com.example.farmaciaspring.model.VentaDetalle;
import com.example.farmaciaspring.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaDetalleService {

    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    public List<VentaDetalle> findByIdventa(int idventa) {
        return ventaDetalleRepository.findByIdventa(idventa);
    }

    public VentaDetalle findById(int id) {
        Optional<VentaDetalle> ventaOptional = ventaDetalleRepository.findById(id);
        return ventaOptional.orElse(null); // Devuelve la venta si lo encuentra, o null si no
    }

    // Obtener todos los clientes
    public List<VentaDetalle> getAllVentas() {
        return ventaDetalleRepository.findAll();
    }

    // Obtener un cliente por su ID
    public VentaDetalle getVentaById(int id) {
        Optional<VentaDetalle> ventaOpt = ventaDetalleRepository.findById(id);
        return ventaOpt.orElse(null); // Retorna null si no se encuentra
    }

    // Agregar un nuevo cliente
    public VentaDetalle addVenta(VentaDetalle venta) {
        return ventaDetalleRepository.save(venta);
    }


    // Eliminar un cliente por su ID
    public void deleteVenta(int id) {
        ventaDetalleRepository.deleteById(id);
    }
}