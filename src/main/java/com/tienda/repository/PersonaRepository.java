/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.repository;

import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Diana Jiménez
 */
@Repository                                            //Java Generics
public interface PersonaRepository extends CrudRepository<Persona,Long>{
    Persona findByNombre (String nombre);   //Metodo que encuentra por el nombre 
    
    //Se pueden ejecutar Querys aca 
}