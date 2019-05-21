package com.miguel.distibuteddatabases.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.dto.PersonaDto;
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
        insertService.save(p);
    }
}
