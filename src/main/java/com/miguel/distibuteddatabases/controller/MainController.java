package com.miguel.distibuteddatabases.controller;

import com.miguel.distibuteddatabases.model.Direccion;
import com.miguel.distibuteddatabases.model.Persona;
import com.miguel.distibuteddatabases.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private InsertService insertService;

    @RequestMapping(value = {"/"})
    public ModelAndView showAll(){
        ModelAndView mav = new ModelAndView("showall");
        mav.addObject("personas", insertService.mostrarPersona());
        mav.addObject("direcciones", insertService.mostrarDireccion());
        return mav;
    }

    @RequestMapping(value = {"/process"})
    public ModelAndView insert(@ModelAttribute("persona") Persona p, @ModelAttribute("direccion") Direccion d){
        insertService.save(p,d);
        ModelAndView mav = new ModelAndView("showall");
        mav.addObject("personas", insertService.mostrarPersona());
        mav.addObject("direcciones", insertService.mostrarDireccion());
        return mav;
    }

    @RequestMapping(value = {"/insert/user"})
    public ModelAndView setUser () {
        ModelAndView mav = new ModelAndView("insertform");
        mav.addObject("persona", new Persona());
        mav.addObject("direccion", new Direccion());
        return mav;

    }
}
