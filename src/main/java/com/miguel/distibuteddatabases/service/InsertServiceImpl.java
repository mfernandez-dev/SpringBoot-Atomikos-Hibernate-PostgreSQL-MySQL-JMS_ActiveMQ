package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.direccion.DireccionDao;
import com.miguel.distibuteddatabases.repository.persona.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class InsertServiceImpl implements InsertService {

    @Autowired
    private PersonaDao personaDao;

    @Autowired
    private DireccionDao dirDao;

    @Override
    public void save(Persona pers, Direccion dir) {
        personaDao.save(pers);
        dirDao.save(dir);
    }

    @Override
    public Optional<Persona> edit(long id) {
       return personaDao.findById(id);
    }

    @Override
    public void save(Persona pers){
        personaDao.save(pers);
    }

    @Override
    public void save(Direccion dir){
        dirDao.save(dir);
    }

    @Override
    public List<Persona> mostrarPersona() {
        List<Persona> x = new ArrayList(personaDao.findAll());
        return x;
    }

    @Override
    public List<Direccion> mostrarDireccion() {
        List<Direccion> x = new ArrayList(dirDao.findAll());
        return x;
    }
}
