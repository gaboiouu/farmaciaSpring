package com.example.farmaciaspring.controller;

import com.example.farmaciaspring.model.Producto;
import com.example.farmaciaspring.model.VentaDetalle;
import com.example.farmaciaspring.service.ProductoService;
import com.example.farmaciaspring.service.VentaService;
import com.example.farmaciaspring.model.Venta;
import com.example.farmaciaspring.model.ventaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> getVentaById(@PathVariable int id) {
        Venta Venta = ventaService.getVentaById(id);
        if (Venta != null) {
            return ResponseEntity.ok(Venta);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Venta> addVenta(@RequestBody ventaDTO  ventaDTO ) {
        Venta venta = new Venta();
        venta.setIdcliente(ventaDTO.getIdcliente());
        venta.setFechaRegistro(ventaDTO.getFechaRegistro());
        venta.setPrecioTotal(ventaDTO.getPrecioTotal());

        // Registrar la venta junto con los detalles
        Venta nuevaVenta = ventaService.addVenta(venta, ventaDTO.getDetalles());

        for (VentaDetalle detalle : ventaDTO.getDetalles()) {
            Producto producto = productoService.getProductoById(detalle.getIdproducto());
            if (producto != null) {
                producto.setCantidad(producto.getCantidad() - detalle.getCantidad());
                productoService.updateProducto(detalle.getIdproducto(), producto);
            }
        }

        return ResponseEntity.ok(nuevaVenta);
        //return ventaService.addVenta(Venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateVenta(@PathVariable int id, @RequestBody Venta Venta) {
        Venta updatedVenta = ventaService.updateVenta(id, Venta);
        if (updatedVenta != null) {
            return ResponseEntity.ok(updatedVenta);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable int id) {
        ventaService.deleteVenta(id);
        return ResponseEntity.noContent().build();
    }
}
