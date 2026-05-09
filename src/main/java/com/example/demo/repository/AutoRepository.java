package com.example.demo.repository;

import com.example.demo.modelo.Auto;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutoRepository
        extends JpaRepository<Auto, String> {

    // METODO 4
    @Query("""
        SELECT a
        FROM Auto a
        WHERE LOWER(a.marca.nombre)=LOWER(:nombre)
    """)
    List<Auto> buscarPorMarca(
            @Param("nombre") String nombre
    );

    // METODO 5
    @Query("""
        SELECT a
        FROM Auto a
        WHERE LOWER(a.marca.nombre)=LOWER(:marca)
        AND a.precio >= :precioMin
        AND a.modelo >= :modelo
    """)
    List<Auto> filtroCompleto(
            @Param("marca") String marca,
            @Param("precioMin") Double precioMin,
            @Param("modelo") Integer modelo
    );
}