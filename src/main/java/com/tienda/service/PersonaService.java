/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana Jiménez
 */

@Service
public class PersonaService implements IPersonaService {    //Implementar todos los métodos abstractos
    
    @Autowired    //Dependencias
    private PersonaRepository personaRepository;        //Objeto de tipo PersonaRepository

    @Override
    public List<Persona> getAllPersona() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override     
    public Persona getPersonaById(long id) {              //id: Parámetro
       return personaRepository.findById(id).orElse(null);   //id: Argumento, Encontrar por el id
       //Si no devuelve la persona por el id, devuelve un null
    }

    @Override
    public void savePersona(Persona persona) {
       personaRepository.save(persona);             //Guardar persona
    }

    @Override
    public void delete(long id) {
      personaRepository.deleteById(id);        //Borrar por el id
    }

}