package com.example.demo.repository;

import com.example.demo.modelo.Auto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AutoRepository
        extends JpaRepository<Auto, String> {

    // BUSCAR POR MARCA
    List<Auto> findByMarca_IdMarca(
            Integer idMarca
    );

    // FILTRO
    List<Auto> findByMarca_IdMarcaAndPrecioGreaterThanEqualAndModeloGreaterThanEqual(

            Integer idMarca,

            BigDecimal precio,

            Integer modelo
    );
}