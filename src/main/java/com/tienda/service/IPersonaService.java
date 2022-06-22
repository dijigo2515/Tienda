/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;

/**
 *
 * @author Diana Jiménez
 */
public interface IPersonaService {            
    public List<Persona> getAllPersona();    //Objeto Persona, devuelve varios elementos, en una lista
    public Persona getPersonaById (long id);   //Obtener persona con el ID 
    public void savePersona (Persona persona);   // Guardar persona 
    public void delete (long id);         //Borrar fila de Id
}