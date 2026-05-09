package com.example.demo.controller;
import java.math.BigDecimal;
import com.example.demo.modelo.Auto;
import com.example.demo.modelo.Marca;

import com.example.demo.repository.AutoRepository;
import com.example.demo.repository.MarcaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ApiController {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private AutoRepository autoRepository;

    // METODO 1
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

    // METODO 2
    @DeleteMapping("/autos/{noSerie}")
    public String eliminarAuto(

            @PathVariable String noSerie
    ) {

        autoRepository.deleteById(noSerie);

        return "Auto eliminado";
    }

    // METODO 3
    @PostMapping("/autos")
    public String registrarAuto(@RequestBody Auto auto) {

        try {

            autoRepository.save(auto);

            return "Auto registrado";

        } catch (Exception e) {

            return e.getMessage();
        }
    }

    
    // METODO 4
    @GetMapping("/autos/marca/{nombre}")
    public List<Auto> autosPorMarca(

            @PathVariable String nombre
    ) {

        return autoRepository.buscarPorMarca(nombre);
    }
    
    
    
    
    // METODO 5 
    @GetMapping("/autos")
    public List<Auto> filtroAutos(

            @RequestParam String marca,

            @RequestParam BigDecimal precioMin,

            @RequestParam Integer modelo
    ) {

        return autoRepository.filtroCompleto(
                marca,
                precioMin,
                modelo
        );
    }
}