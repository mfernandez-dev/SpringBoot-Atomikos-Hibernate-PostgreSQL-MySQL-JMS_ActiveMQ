package com.miguel.distibuteddatabases.repository.dto;

import java.io.Serializable;

@SuppressWarnings("ALL")
public class PersonaDto implements Serializable {

    private String accion;

    private long id;

    private String nombre;

    private String apellido;

    public PersonaDto() {
    }

    public PersonaDto(String accion, long id,String nombre, String apellido) {
        this.accion = accion;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getAccion() { return accion; }

    public void setAccion(String accion) { this.accion = accion; }

    public long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
