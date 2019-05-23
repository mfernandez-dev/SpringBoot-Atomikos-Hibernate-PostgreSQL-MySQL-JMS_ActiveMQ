package com.miguel.distibuteddatabases.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguel.distibuteddatabases.repository.dto.AllDataDto;
import com.miguel.distibuteddatabases.repository.dto.DireccionDto;
import com.miguel.distibuteddatabases.repository.dto.PersonaDto;
import com.miguel.distibuteddatabases.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.Queue;
import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private InsertService insertService;

    @Autowired
    private Queue queue;



    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping(value = {"/"})
    public ModelAndView showAll() {
        ModelAndView mav = new ModelAndView("showall");
        mav.addObject("personas", insertService.mostrarPersona());
        mav.addObject("direcciones", insertService.mostrarDireccion());
        return mav;
    }

    @RequestMapping(value = {"/insert/all"})
    public ModelAndView setData() {
        ModelAndView mav = new ModelAndView("insertform");
        mav.addObject("all", new AllDataDto());
        return mav;
    }

    @RequestMapping(value = {"/edit/persona"})
    public ModelAndView editPersona(@RequestParam("personaid") long id) {
        ModelAndView mav = new ModelAndView("editpers");
        mav.addObject("persona",insertService.edit(id));
        return mav;
    }

    @RequestMapping(value = {"/edit/direccion"})
    public ModelAndView editDir (@RequestParam("dirid") long id){
        ModelAndView mav = new ModelAndView("editdir");
        mav.addObject("direccion", insertService.editDir(id));
        return mav;
    }

    @RequestMapping("/publish")
    public ModelAndView publish (@ModelAttribute("all") AllDataDto all) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String  allDataDto = objectMapper.writeValueAsString(all);
        jmsTemplate.convertAndSend(queue,allDataDto);
        return new ModelAndView("end");
    }

    @RequestMapping(value = {"/editordeleteperson"})
    public ModelAndView editOrDeletePerson(@ModelAttribute("persona") PersonaDto personaDto) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String pers = objectMapper.writeValueAsString(personaDto);
        jmsTemplate.convertAndSend(queue, pers);
        return new ModelAndView("end");
    }

    @RequestMapping(value = {"/editordeletedireccion"})
    public ModelAndView editOrDeleteDireccion (@ModelAttribute("direccion") DireccionDto direccionDto) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String dir = objectMapper.writeValueAsString(direccionDto);
        jmsTemplate.convertAndSend(queue, dir);
        return new ModelAndView("end");
    }
}
