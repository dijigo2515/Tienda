/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author Diana Jiménez
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Bean                                              /* Dependencias de configuracion*/
    public SessionLocaleResolver localeResolver(){     /*Crear un objeto nuevo*/
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));         /*Setear idioma*/
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");                                /*Detectar el cambio que haya en las paginas*/
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());     /*Detecta todo el cambio*/
    }
    
}
