package com.example.demo.modelo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "autos")

public class Auto {

    @Id
    @Column(name = "no_serie")
    private String noSerie;

    private String tipo;

    private Integer modelo;

    private BigDecimal precio;

    @ManyToOne
    @JoinColumn(
    	    name = "id_marca",
    	    referencedColumnName = "id_marca"
    	)

    @JsonIgnoreProperties({
            "hibernateLazyInitializer",
            "handler"
    })

    private Marca marca;

    // CONSTRUCTOR VACIO
    public Auto() {
    }

    // CONSTRUCTOR LLENO
    public Auto(
            String noSerie,
            String tipo,
            Integer modelo,
            BigDecimal precio,
            Marca marca
    ) {

        this.noSerie = noSerie;
        this.tipo = tipo;
        this.modelo = modelo;
        this.precio = precio;
        this.marca = marca;
    }

    // GETTERS Y SETTERS

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}