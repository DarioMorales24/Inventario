package com.inventario.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventario.service.InventarioService;
import com.inventario.model.Producto;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    @Autowired
    private InventarioService service;

    // Cargar datos de prueba al iniciar
    @PostConstruct
    public void init() {
        if (service.contarProductos() == 0) {
            service.crearProducto(new Producto("101", "Laptop Gamer", 15));
            service.crearProducto(new Producto("102", "Mouse Inalámbrico", 50));
            service.crearProducto(new Producto("103", "Teclado Mecánico", 30));
        }
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return service.crearProducto(producto);
    }

    @GetMapping
    public List<Producto> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable String id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String id, @RequestBody Producto detalles) {
        return service.actualizarProducto(id, detalles)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String id) {
        if (service.eliminarProducto(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}