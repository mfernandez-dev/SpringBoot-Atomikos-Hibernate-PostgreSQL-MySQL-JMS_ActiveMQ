package com.miguel.distibuteddatabases.service;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.direccion.DireccionDao;
import com.miguel.distibuteddatabases.repository.dto.DireccionDto;
import com.miguel.distibuteddatabases.repository.dto.PersonaDto;
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
public class InsertServiceImpl implements InsertService{

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
    public void save(Persona pers){
        personaDao.save(pers);
    }

    @Override
    public void save(Direccion dir){
        dirDao.save(dir);
    }

    @Override
    public PersonaDto edit(long id) {
       PersonaDto pers = new PersonaDto();
       Optional<Persona> p = personaDao.findById(id);
       Persona persona = p.get();

       pers.setId(persona.getId());
       pers.setNombre(persona.getNombre());
       pers.setApellido(persona.getApellido());
       return pers;
    }

    @Override
    public DireccionDto editDir(long id) {
        DireccionDto dir = new DireccionDto();
        Optional<Direccion> d = dirDao.findById(id);
        Direccion direccion = d.get();

        dir.setId(direccion.getId());
        dir.setCalle(direccion.getCalle());
        dir.setNumero(direccion.getNumero());
        dir.setCiudad(direccion.getCiudad());

        return dir;
    }

    @Override
    public ArrayList mostrarPersona() {
        return new ArrayList<>(personaDao.findAll());
    }

    @Override
    public List<Direccion> mostrarDireccion() {
        return new ArrayList<>(dirDao.findAll());
    }

    @Override
    public void deletePers(long id) {
        personaDao.deleteById(id);
    }

    @Override
    public void deleteDir(long id) {
        dirDao.deleteById(id);
    }
}
