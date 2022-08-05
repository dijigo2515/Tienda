/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.service.api;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.tienda.model.ReporteVentasDTO;

import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Diana Jiménez
 */
public interface ReporteVentasServiceAPI {
    
 ReporteVentasDTO obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException;

}
