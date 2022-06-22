/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Diana Jiménez
 */
@Controller
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IPaisService paisService;

    @GetMapping("/persona")      //Cuando escribamos un URL el va a saber que tiene que hacer
    //Cuando se le indica /persona, debe realizar todo lo que este abajo
    public String index(Model model) {                                   //   model pasa información de variables al HTML
        List<Persona> listaPersona = personaService.getAllPersona();
        model.addAttribute("titulo", "Tabla Personas");                   //Cuando vea"titulo", va a sustituirlo por Tabla Personas
        model.addAttribute("personas", listaPersona);
        return "personas";                                                //Devuelve un HTML que se llame personas
    }

    @GetMapping("/personaN")
    //Metodo para guardar nueva persona
    public String crearPersona(Model model) {
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", new Persona());           //Le pasamos un objeto de tipo persona, creando un objeto nuevo  
        model.addAttribute("paises", listaPaises);     //Pasamos la lista de paises desde la base de datos
        return "crear";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona) {
        personaService.savePersona(persona);                  //Guardando la nueva persona en la base de datos, nueva fila
        return "redirect:/persona";            //Redije a otro getmapping    
    }

    @GetMapping("/editpersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model) {
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona", persona);                    //Le pasamos una persona, ya creada
        model.addAttribute("paises", listaPaises);
        return "crear";
    }

    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long idPersona) {  //No quiero pasarle info, solo eliminar persona
        personaService.delete(idPersona);
        return "redirect:/persona";
    }
}
