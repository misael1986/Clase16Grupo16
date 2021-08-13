/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unbosque.clase16grupo16;

/**
 * Reto 4 mejorado para ser parecido al reto 5 con GUI
 *
 * @author Usuario
 * @version 3.5
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Controlador control = new Controlador(new Vista(), new ServiciosPersona());
        //                                                    Modelo usando DTO
        
        new ControlSWING(new VistaSWING(), new ServiciosPersona());
        
        
    }

}
