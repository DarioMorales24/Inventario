package com.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventario.model.Producto;
import com.inventario.repository.InventarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository repository;

    public Producto crearProducto(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Producto> obtenerPorId(String id) {
        return repository.findById(id);
    }

    public Optional<Producto> actualizarProducto(String id, Producto detalles) {
        return repository.findById(id).map(producto -> {
            producto.setNombre(detalles.getNombre());
            producto.setStock(detalles.getStock());
            return repository.save(producto);
        });
    }

    public boolean eliminarProducto(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public long contarProductos() {
        return repository.count();
    }
}