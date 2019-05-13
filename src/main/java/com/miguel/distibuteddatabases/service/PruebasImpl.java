package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PruebasImpl implements Pruebas {

    @Autowired
    private InsertService insertService;

    @Override
    public List<Persona> mostrarPersonaP() {
        List<Persona> x = new ArrayList(insertService.mostrarPersona());
        return x;
    }

    @Override
    public List<Direccion> mostrarDireccionP() {
        List<Direccion> x = new ArrayList(insertService.mostrarDireccion());
        return x;
    }
}