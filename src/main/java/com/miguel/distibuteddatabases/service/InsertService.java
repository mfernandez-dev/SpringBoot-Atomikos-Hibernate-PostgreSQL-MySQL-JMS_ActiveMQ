package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.dto.DireccionDto;
import com.miguel.distibuteddatabases.repository.dto.PersonaDto;

import java.util.ArrayList;
import java.util.List;

public interface InsertService {

    void save(Persona pers, Direccion dir);

    void save(Persona pers);

    void save(Direccion dir);

    PersonaDto edit(long id);

   DireccionDto editDir(long id);

    ArrayList mostrarPersona();

    List<Direccion> mostrarDireccion();

    void deletePers(long id);

    void deleteDir(long id);
}
