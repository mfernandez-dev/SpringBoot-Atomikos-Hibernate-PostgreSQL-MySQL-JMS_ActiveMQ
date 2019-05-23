package com.miguel.distibuteddatabases.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.repository.dto.AllDataDto;
import com.miguel.distibuteddatabases.repository.dto.DireccionDto;
import com.miguel.distibuteddatabases.repository.dto.PersonaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

    @Autowired
    InsertService insertService;

    @Autowired
    ObjectMapper objectMapper;

    @JmsListener(destination = "cola-insert")
    public void listener(String all) throws IOException {
            if (all.contains("insert")) {
                AllDataDto allDataDto = objectMapper.readValue(all, AllDataDto.class);
                if (allDataDto.getAccion().equals("insert"))
                    insert(allDataDto);
            }
            if (all.contains("edit") && all.contains("nombre")){
                PersonaDto personaDto = objectMapper.readValue(all, PersonaDto.class);
                if (personaDto.getAccion().equals("edit"))
                    edit(personaDto);
            }

            if (all.contains("delete") && all.contains("nombre")){
                PersonaDto personaDto = objectMapper.readValue(all, PersonaDto.class);
                if(personaDto.getAccion().equals("delete"))
                    delete(personaDto);
            }

            if (all.contains("edit") && all.contains("calle")){
                DireccionDto direccionDto = objectMapper.readValue(all, DireccionDto.class);
                if (direccionDto.getAccion().equals("edit"))
                    edit(direccionDto);
            }

            if (all.contains("delete") && all.contains("calle")){
                DireccionDto direccionDto = objectMapper.readValue(all, DireccionDto.class);
                if (direccionDto.getAccion().equals("delete"))
                    delete(direccionDto);
            }

    }

    private void insert (AllDataDto allDataDto){
        Persona p = new Persona (allDataDto.getNombre(), allDataDto.getApellido());
        Direccion d = new Direccion (allDataDto.getCalle(), allDataDto.getNumero(), allDataDto.getCiudad());

        if (!p.getNombre().equals("") && !d.getCalle().equals(""))
            insertService.save(p,d);
            else if (!p.getNombre().equals("") && d.getCalle().equals(""))
                insertService.save(p);
                else if (p.getNombre().equals("") && !d.getCalle().equals(""))
                    insertService.save(d);
    }

    private void edit (PersonaDto personaDto){
        Persona p = new Persona(personaDto.getId(),personaDto.getNombre(), personaDto.getApellido());
        insertService.save(p);
    }

    private void edit (DireccionDto direccionDto){
        Direccion d = new Direccion(direccionDto.getId(), direccionDto.getCalle(), direccionDto.getNumero(), direccionDto.getCiudad());
        insertService.save(d);
    }

    private void delete (PersonaDto personaDto){
        insertService.deletePers(personaDto.getId());
    }

    private void delete( DireccionDto direccionDto){
        insertService.deleteDir(direccionDto.getId());
    }
}
