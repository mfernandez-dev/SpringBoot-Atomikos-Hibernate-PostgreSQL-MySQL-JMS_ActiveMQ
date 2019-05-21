package com.miguel.distibuteddatabases.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

    @Autowired
    InsertService insertService;

    @JmsListener(destination = "simple-jms-queue")
    public void listener(String pers) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            Persona p = objectMapper.readValue(pers, Persona.class);
            if (!p.getNombre().equals(""))
                insertService.save(p);
    }

    @JmsListener (destination = "simple-jms-queueb")
    public void listnerb(String dir) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Direccion d = objectMapper.readValue(dir, Direccion.class);
        if (!d.getCalle().equals(""))
            insertService.save(d);
    }

}
