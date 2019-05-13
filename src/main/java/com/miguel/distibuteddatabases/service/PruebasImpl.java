package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.persona.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)     //para que no salte el bug hay que cambiar el propagation o el isolation
public class PruebasImpl implements Pruebas {

    @Autowired
    private InsertService insertService;

    @Autowired
    private PersonaDao personaDao;

    @Override
    public List<Optional<Persona>> mostrarPersonaP() {
        Optional<Persona> p = personaDao.findById((long) 48);
        List<Optional<Persona>> x = new ArrayList(insertService.mostrarPersona());
        x.add(p);

        return x;
    }

    @Override
    public List<Direccion> mostrarDireccionP() {
        List<Direccion> x = new ArrayList(insertService.mostrarDireccion());
        return x;
    }
}