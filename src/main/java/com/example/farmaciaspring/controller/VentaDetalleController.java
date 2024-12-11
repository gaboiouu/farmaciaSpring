package com.example.farmaciaspring.controller;

import com.example.farmaciaspring.model.VentaDetalle;
import com.example.farmaciaspring.service.VentaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventadetalle")
public class VentaDetalleController {

    @GetMapping("/detalle/{idventa}")
    public ResponseEntity<List<VentaDetalle>> getVentaDetallesByIdventa(@PathVariable int idventa) {
        List<VentaDetalle> detalles = ventaDetalleService.findByIdventa(idventa);
        if (detalles != null && !detalles.isEmpty()) {
            return ResponseEntity.ok(detalles);
        }
        return ResponseEntity.notFound().build();
    }

    @Autowired
    private VentaDetalleService ventaDetalleService;

    @GetMapping
    public List<VentaDetalle> getAllVentasDetalles() {
        return ventaDetalleService.getAllVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDetalle> getVentaDetalleById(@PathVariable int id) {
        VentaDetalle Venta = ventaDetalleService.getVentaById(id);
        if (Venta != null) {
            return ResponseEntity.ok(Venta);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public VentaDetalle addVenta(@RequestBody VentaDetalle Venta) {
        return ventaDetalleService.addVenta(Venta);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable int id) {
        ventaDetalleService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }
}
