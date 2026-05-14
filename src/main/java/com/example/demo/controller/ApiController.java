package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.modelo.Auto;
import com.example.demo.modelo.Marca;

import com.example.demo.repository.AutoRepository;
import com.example.demo.repository.MarcaRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class ApiController {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private AutoRepository autoRepository;

    // =====================================
    // OBTENER MARCAS
    // =====================================

    @GetMapping("/marcas")

    public Page<Marca> obtenerMarcas(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size
    ) {

        return marcaRepository.findAll(
                PageRequest.of(page, size)
        );
    }

    // =====================================
    // OBTENER TODOS LOS AUTOS O FILTRAR
    // =====================================

    @GetMapping("/autos")

    public List<Auto> filtroAutos(

            @RequestParam(required = false)
            Integer idMarca,

            @RequestParam(required = false)
            BigDecimal precioMin,

            @RequestParam(required = false)
            Integer modelo
    ) {

        // SI VIENEN LOS 3 PARÁMETROS
        if (
                idMarca != null &&
                precioMin != null &&
                modelo != null
        ) {

            return autoRepository
                    .findByMarca_IdMarcaAndPrecioGreaterThanEqualAndModeloGreaterThanEqual(

                            idMarca,
                            precioMin,
                            modelo
                    );
        }

        // SI NO, TRAER TODOS
        return autoRepository.findAll();
    }

    // =====================================
    // BUSCAR AUTOS POR MARCA
    // =====================================

    @GetMapping("/autos/marca/{idMarca}")

    public List<Auto> autosPorMarca(
            @PathVariable Integer idMarca
    ) {

        return autoRepository.findByMarca_IdMarca(idMarca);
    }

    // =====================================
    // REGISTRAR AUTO
    // =====================================

    @PostMapping("/autos")

    public String registrarAuto(
            @RequestBody Auto auto
    ) {

        try {

            autoRepository.save(auto);

            return "Auto registrado";

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    // =====================================
    // ELIMINAR AUTO
    // =====================================

    @DeleteMapping("/autos/{noSerie}")

    public String eliminarAuto(
            @PathVariable String noSerie
    ) {

        autoRepository.deleteById(noSerie);

        return "Auto eliminado";
    }

    // =====================================
    // REGISTRAR MARCA
    // =====================================

    @PostMapping("/marcas")

    public String registrarMarca(
            @RequestBody Marca marca
    ) {

        try {

            marcaRepository.save(marca);

            return "Marca registrada";

        } catch (Exception e) {

            return e.getMessage();
        }
    }
}