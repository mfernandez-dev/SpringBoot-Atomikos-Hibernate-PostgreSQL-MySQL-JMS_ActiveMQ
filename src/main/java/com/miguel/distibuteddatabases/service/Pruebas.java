package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;

import java.util.List;
import java.util.Optional;

public interface Pruebas {

    List<Optional<Persona>> mostrarPersonaP();

    List<Direccion> mostrarDireccionP();
}
