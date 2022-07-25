/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author Diana Jiménez
 */
@Configuration 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserService userDetailsService;
    
    @Bean                                             //Indica que el metodo que estemos usando para el configuration
    public BCryptPasswordEncoder passwordEncoder(){      //Tipo de codificador Bcrypt 
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserService getUserService(){    
        return new UserService();
    }
    
    @Bean 
    DaoAuthenticationProvider authenticationProvider(){   //
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());    //Tipo de metodo que devuelve bcrypt
        daoAuthenticationProvider.setUserDetailsService(getUserService());  //Pasarle el user implementacion que estamos utilizando
        return daoAuthenticationProvider;
    }
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){   //Que hago si la autenticacion es exitosa
        return new AppAuthenticationSuccessHandler();
    }
    public SecurityConfig(UserService userPrincipalDetailsService){
        this.userDetailsService = userPrincipalDetailsService;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth){    //Se encarga de la autenticacion 
        auth.authenticationProvider(authenticationProvider());
    }
    
    //El siguiente metodo funciona para hacer la autenticacion del usuario
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests()
                .antMatchers("/persona","/login","/personasN")
                .hasRole("ADMIN")
                .antMatchers("/persona","/","/login")               //Redirigir a algun lado con "/" a cualquier lado 
                .hasAnyRole("USER","VENDEDOR","ADMIN")    //Roles 
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/persona",true); //Utilizar nuestro login, redirigir
    } 
    
}
