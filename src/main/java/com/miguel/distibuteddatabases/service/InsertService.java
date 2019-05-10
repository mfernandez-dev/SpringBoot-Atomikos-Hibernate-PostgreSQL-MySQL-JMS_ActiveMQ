package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;

import java.util.List;
import java.util.Optional;

public interface InsertService {

    void save (Persona pers, Direccion dir);

    Optional<Persona> edit (long id);

    Optional<Direccion> editDir (long id);

    void save (Persona pers);

    void save (Direccion dir);

    List<Persona> mostrarPersona();

    List<Direccion> mostrarDireccion();
}
