package com.miguel.distibuteddatabases.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.dto.AllDataDto;
import com.miguel.distibuteddatabases.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

    @Autowired
    InsertService insertService;

    @JmsListener(destination = "cola-insert")
    public void listener(String all) throws IOException {
            if (all.contains("insert")) {
                ObjectMapper objectMapper = new ObjectMapper();
                AllDataDto allDataDto = objectMapper.readValue(all, AllDataDto.class);
                if (allDataDto.getAccion().equals("insert"))
                    insert(allDataDto);
            }

    }

    public void insert (AllDataDto allDataDto){
        Persona p = new Persona (allDataDto.getNombre(), allDataDto.getApellido());
        Direccion d = new Direccion (allDataDto.getCalle(), allDataDto.getNumero(), allDataDto.getCiudad());

        if (!p.getNombre().equals("") && !d.getCalle().equals(""))
            insertService.save(p,d);
            else if (!p.getNombre().equals("") && d.getCalle().equals(""))
                insertService.save(p);
                else if (p.getNombre().equals("") && !d.getCalle().equals(""))
                    insertService.save(d);
    }
}
