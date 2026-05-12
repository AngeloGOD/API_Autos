package com.example.demo.repository;

import com.example.demo.modelo.Auto;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface AutoRepository
        extends JpaRepository<Auto, String> {

    // METODO 4 (por id_marca)
    @Query("""
        SELECT a
        FROM Auto a
        WHERE a.idMarca = :idMarca
    """)
    List<Auto> buscarPorMarca(
            @Param("idMarca") Integer idMarca
    );

    // METODO 5 (filtro completo corregido)
    @Query("""
        SELECT a
        FROM Auto a
        WHERE a.idMarca = :idMarca
        AND a.precio >= :precioMin
        AND a.modelo >= :modelo
    """)
    List<Auto> filtroCompleto(
            @Param("idMarca") Integer idMarca,
            @Param("precioMin") BigDecimal precioMin,
            @Param("modelo") Integer modelo
    );
}