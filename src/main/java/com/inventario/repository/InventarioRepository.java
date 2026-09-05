package com.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventario.model.Producto;

public interface InventarioRepository extends JpaRepository<Producto, String>{
    
}
