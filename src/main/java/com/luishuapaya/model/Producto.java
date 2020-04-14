package com.luishuapaya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// JPQL
// FROM producto p(nombre de la entidad) WHERE p.idPaciente = 1 
@Entity //(name = "producto") //para colocarle un alias a la entidad 
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @Column(name = "marca", nullable = false, length = 70)
    private String marca;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}