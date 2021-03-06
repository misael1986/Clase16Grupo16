/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unbosque.clase16grupo16;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 * @version 1.5
 *
 */
public class Vista {

    private int opcion, consultas;
    private long edadRem;
    private String nomRemp, apeRemp, mailRemp, carreraRemp;

    Vista() {

    }

    /**
     * @return the opcion
     */
    public int getOpcion() {
        return opcion;
    }

    /**
     * @param opcion the opcion to set
     */
    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public int getConsultas() {
        return consultas;
    }

    /**
     * @param opcion the opcion to set
     */
    public void setConsultas(int consul) {
        this.consultas = consul;
    }

    /**
     * @return the edadRem
     */
    public long getEdadRem() {
        return edadRem;
    }

    /**
     * @param edadRem the edadRem to set
     */
    public void setEdadRem(long edadRem) {
        this.edadRem = edadRem;
    }

    /**
     * @return the nomRemp
     */
    public String getNomRemp() {
        return nomRemp;
    }

    /**
     * el parametro nomRemp es usado para asignarlo al atrubuto de la clase
     * Vista, que posteriormente será enviado al modelo del este proyecto
     *
     * @param nomRemp recibe un String para ser asignado a this.nomRemp
     */
    public void setNomRemp(String nomRemp) {
        this.nomRemp = nomRemp;
    }

    /**
     * Explicar que retorna y para que se usa
     *
     * @return el atributo apeRemp
     */
    public String getApeRemp() {
        return apeRemp;
    }

    /**
     * @param apeRemp the apeRemp to set
     */
    public void setApeRemp(String apeRemp) {
        this.apeRemp = apeRemp;
    }

    public String getEmailRemp() {
        return mailRemp;
    }

    /**
     * @param apeRemp the apeRemp to set
     */
    public void setEmailRemp(String mail) {
        this.mailRemp = mail;
    }

    public String getCarreraRemp() {
        return carreraRemp;
    }

    /**
     * @param apeRemp the apeRemp to set
     */
    public void setCarreraRemp(String carrera) {
        this.carreraRemp = carrera;
    }

    //---------------------------------------------------------  
    public int Menu() {

        Scanner menu = new Scanner(System.in);
        this.opcion = 0;

        System.out.println("INSTITUTO LA FLORESTA\n"
                + "Seleccione tarea a realizar:\n"
                + "1. Ingresar Persona\n"
                + "2. Consultas\n"
                + "3. Modificar Persona\n"
                + "4. Eliminar Persona\n"
                + "5. Ver directorio de Persona\n"
                + "6. Salir\n"
                + "Opción:");
        this.opcion = menu.nextInt();

        return this.opcion;

    }

    public void PedirDatos() {
        Scanner menu = new Scanner(System.in);

        System.out.println("Ingresar persona\n"
                + "Ingresar nombres:");
        this.setNomRemp(menu.next());

        System.out.println("Ingresar apellidos:");
        this.setApeRemp(menu.next());

        System.out.println("Ingresar edad:");
        try {
            this.setEdadRem(menu.nextLong());//no hubo tiempo para validar la entrada de manera correcta
        } catch (Exception ernum) {
            System.out.println("Problema con la captura del numero: " + ernum.getMessage());
            this.setEdadRem(0);
        }
        System.out.println("Ingresar Email:");
        this.setEmailRemp(menu.next());

        System.out.println("Ingresar Carrera:");
        this.setCarreraRemp(menu.next());

    }

    /**
     *
     */
    public void buscarApellido() {
        Scanner menu = new Scanner(System.in);
        System.out.println("Digite Apellido:");
        this.setApeRemp(menu.next());
    }

    /**
     *
     */
    public void buscarEmail() {
        Scanner menu = new Scanner(System.in);
        System.out.println("Digite Email:");
        this.setEmailRemp(menu.next());
    }

    /**
     *
     */
    public void buscarCarrera() {
        Scanner menu = new Scanner(System.in);
        System.out.println("Digite Carrera:");
        this.setCarreraRemp(menu.next());
    }

    /**
     *
     */
    public void buscarEdad() {
        Scanner menu = new Scanner(System.in);
        System.out.println("Digite Edad:");
        this.setEdadRem(menu.nextLong());
    }

    /**
     *
     * @param msj
     */
    public void Mensajes(String msj) {
        System.out.println(msj);
    }

    /**
     *
     * @param buscada
     */
    public void ImprimirBuscado(Persona buscada) {

        System.out.println("Encontrado: \n Nombre:" + buscada.getNombre()
                + "\n Apellidos: "
                + buscada.getApellidos() + "\nEdad: " + buscada.getEdad()
                + "\nEmail: " + buscada.getEmail()
                + "\nCarrera: " + buscada.getCarrera());

    }

    /**
     *
     * @param varios
     */
    public void ImprimirVarios(ArrayList<Persona> varios) {

        if (varios == null) {
            System.out.println("No hay resultados para esa consulta");
        } else {
            System.out.println("Encontrados: \n");
            for (Persona p : varios) {
                System.out.println("Nombre:" + p.getNombre()
                        + "\nApellidos: " + p.getApellidos()
                        + "\nEdad: " + p.getEdad()
                        + "\nEmail: " + p.getEmail()
                        + "\nCarrera: " + p.getCarrera() + "\n");

            }
        }
    }

    /**
     *
     * @param varios
     */
    public void ImprimirAlumnosCarrera(ArrayList<Persona> varios) {
        System.out.println("Encontrados que estudian " + this.getCarreraRemp() + " :\n");
        for (Persona p : varios) {
            System.out.println("Nombre:" + p.getNombre()
                    + "\nApellidos: " + p.getApellidos()
                    + "\n");

        }
    }

    public void ImprimirAlumnosApellidos(ArrayList<Persona> varios) {
        //System.out.println("Encontrados con apellido " + this.getApeRemp() + " : \n");
        for (Persona p : varios) {
            System.out.println(p.getApellidos()+" "+ p.getNombre()
                    + " " + p.getCarrera()
                    + "\n");

        }
    }

    public int MenuConsultas() {
        Scanner menu = new Scanner(System.in);
        System.out.println("Consultas\n"
                + "Seleccione consulta a realizar:\n"
                + "1. Buscar estudiante por correo electrónico\n"
                + "2. Buscar estudiante por apellidos\n"
                + "3. Bucar por programa\n"
                + "4. Buscar cantidad de estudiantes por programa\n"
                + "5. Buscar por edad\n"
                + "6. Buscar por Apellido 2\n"
                + "Opción:");
        this.consultas = menu.nextInt();
        return consultas;

    }

}
