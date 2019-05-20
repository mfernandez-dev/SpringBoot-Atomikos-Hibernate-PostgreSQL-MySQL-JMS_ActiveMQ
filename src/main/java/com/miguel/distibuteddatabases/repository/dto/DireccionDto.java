package com.miguel.distibuteddatabases.repository.dto;

public class DireccionDto {

    private String calle;

    private int numero;

    private String ciudad;

    public DireccionDto() {
    }

    public DireccionDto(String calle, int numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
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
