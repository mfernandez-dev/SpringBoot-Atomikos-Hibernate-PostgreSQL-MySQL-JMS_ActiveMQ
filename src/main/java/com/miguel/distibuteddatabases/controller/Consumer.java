package com.miguel.distibuteddatabases.controller;

import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.dto.PersonaDto;
import com.miguel.distibuteddatabases.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    InsertService insertService;

    @JmsListener(destination = "simple-jms-queue")
    public void listener(PersonaDto pers){

        Persona p = new Persona();
        p.setNombre(pers.getNombre());
        p.setApellido(pers.getApellido());

        insertService.save(p);
    }
}
