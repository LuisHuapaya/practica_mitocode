package com.luishuapaya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona") //nombre de la tabla en la BD
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para ponerle un autoincremental
    private Integer idPersona;

    @Column(name = "nombres", nullable = false, length = 70) //nombre de la columna en BD
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 70)
    private String apellidos;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    

}