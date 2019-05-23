package com.miguel.distibuteddatabases.repository.dto;

@SuppressWarnings("ALL")
public class DireccionDto {

    private String accion;

    private long id;

    private String calle;

    private int numero;

    private String ciudad;

    public DireccionDto() {
    }

    public DireccionDto(String accion, long id, String calle, int numero, String ciudad) {
        this.accion = accion;
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "DireccionDto{" +
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
