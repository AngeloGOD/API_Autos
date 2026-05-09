package com.example.demo.modelo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "marcas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_marca")
    private Integer idMarca;

    private String nombre;

    private String pais;

    // constructor vacio
    public Marca() {
    }

    // constructor lleno
    public Marca(Integer idMarca,
                 String nombre,
                 String pais) {

        this.idMarca = idMarca;
        this.nombre = nombre;
        this.pais = pais;
    }

    // getters y setters

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}