package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.DireccionDao;
import com.miguel.distibuteddatabases.repository.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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
