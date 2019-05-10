package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;

import java.util.List;
import java.util.Optional;

public interface InsertService {

    void save (Persona pers, Direccion dir);

    void save (Persona pers);

    void save (Direccion dir);

    Optional<Persona> edit (long id);

    Optional<Direccion> editDir (long id);

    List<Persona> mostrarPersona();

    List<Direccion> mostrarDireccion();

    void deletePers (long id);

    void deleteDir (long id);
}
