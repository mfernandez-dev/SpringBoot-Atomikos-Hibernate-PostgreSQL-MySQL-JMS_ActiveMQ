package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InsertServiceImpl implements InsertService {

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private Direccion dirDao;

    @Override
    public void save(Persona pers, Direccion dir) {

    }

    @Override
    public List<Persona> mostrarPersona() {
        return null;
    }

    @Override
    public List<Direccion> mostrarDireccion() {
        return null;
    }
}
