package com.example.demo.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "autos")

public class Auto {

    @Id
    @Column(name = "no_serie")
    private String noSerie;

    private String tipo;

    private Integer modelo;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    // constructor vacio
    public Auto() {
    }

    // constructor lleno
    public Auto(String noSerie,
                String tipo,
                Integer modelo,
                Double precio,
                Marca marca) {

        this.noSerie = noSerie;
        this.tipo = tipo;
        this.modelo = modelo;
        this.precio = precio;
        this.marca = marca;
    }

    // getters y setters

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}