package com.example.farmaciaspring.service;

import com.example.farmaciaspring.model.Venta;
import com.example.farmaciaspring.model.VentaDetalle;
import com.example.farmaciaspring.repository.VentaRepository;
import com.example.farmaciaspring.repository.VentaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private VentaDetalleRepository ventaDetalleRepository;

    public Venta findById(int id) {
        Optional<Venta> ventaOptional = ventaRepository.findById(id);
        return ventaOptional.orElse(null); // Devuelve la venta si lo encuentra, o null si no
    }

    // Obtener todos los clientes
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    // Obtener un cliente por su ID
    public Venta getVentaById(int id) {
        Optional<Venta> ventaOpt = ventaRepository.findById(id);
        return ventaOpt.orElse(null); // Retorna null si no se encuentra
    }

    // Agregar un nuevo cliente
    public Venta addVenta(Venta venta, List<VentaDetalle> detalles) {
        // Guardar la venta
        Venta nuevaVenta = ventaRepository.save(venta);

        // Guardar los detalles de la venta
        for (VentaDetalle detalle : detalles) {
            detalle.setIdventa(nuevaVenta.getId());
            ventaDetalleRepository.save(detalle);
        }

        return nuevaVenta;
        //return ventaRepository.save(venta);
    }

    // Actualizar un cliente existente
    public Venta updateVenta(int id, Venta venta) {
        if (ventaRepository.existsById(id)) {
            venta.setId(id); // Asegúrate de que el ID se mantenga
            return ventaRepository.save(venta);
        }
        return null; // Retorna null si no se encuentra
    }

    // Eliminar un cliente por su ID
    public void deleteVenta(int id) {
        ventaRepository.deleteById(id);
    }
}