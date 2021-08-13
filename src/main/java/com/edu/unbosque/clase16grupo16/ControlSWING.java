/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unbosque.clase16grupo16;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Misael Fdo Perilla - UNBOSQUE
 * @version 1.0.1
 * @since 2021
 * @see ArrayList
 */
public class ControlSWING implements ActionListener {

    VistaSWING v;//Parametro para utilizar la vista y capturar/enviar datos al usuario
    ServiciosPersona m;
    String temp;//HIDDEN - Oculto

    ControlSWING(VistaSWING vis, ServiciosPersona mod) {
        this.v = vis;
        this.m = mod;

        this.v.cerrar.addActionListener(this);
        this.v.buscar.addActionListener(this);
        this.v.crear.addActionListener(this);
        this.v.elim.addActionListener(this);
        this.v.modif.addActionListener(this);
        this.v.todos.addActionListener(this);
        this.v.acercade.addActionListener(this);
        this.v.todotabla.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.v.cerrar) {
            System.exit(0);//Fuerza el cierre del programa
        }
        if (e.getSource() == this.v.acercade) {
            //System.out.println("Entra a Acerca de");
            this.v.acercaDe();
        }
        if (e.getSource() == this.v.B_borrar) {
            //System.out.println("Si hace clic en Boton Borrar");
            this.v.T_apeRemp.setText("");
            this.v.T_carreraRemp.setText("");
            this.v.T_edadRem.setText("");
            this.v.T_mailRemp.setText("");
            this.v.T_nomRemp.setText("");
            this.v.T_Buscador.setText("");
            this.v.A_resultados.setText("");

        }
        if (e.getSource() == this.v.B_guardar) {
            int ex = this.m.LlenarLista(this.v.T_nomRemp.getText(),
                    this.v.T_apeRemp.getText(),
                    Long.parseLong(this.v.T_edadRem.getText()),
                    this.v.T_mailRemp.getText(),
                    this.v.T_carreraRemp.getText()
            );
            if (ex == 1) {
                JOptionPane.showMessageDialog(v, "Persona guardada con Exito");
            } else {
                JOptionPane.showMessageDialog(v, "Error al guardar Persona",
                        "Failure", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (e.getSource() == this.v.B_buscarEsp) {

            ArrayList<Persona> X = this.m.buscarParticular(this.v.T_Buscador.getText());
            String todo = "";
            System.out.println(X);
            if (X.isEmpty()) {//Para validar que un ArrayList no trae datos pero no
                //es igual a NULL
                todo = "Consulta no da resultados";
            } else {
                for (Persona p : X) {
                    todo = todo + "Nombre: " + p.getNombre() + "\n"
                            + "Apellido: " + p.getApellidos() + "\n"
                            + "Edad: " + p.getEdad() + "\n"
                            + "Email: " + p.getEmail() + "\n"
                            + "Carrera: " + p.getCarrera() + "\n\n";
                }

            }
            this.v.A_resultados.setText(todo);

        }

        if (e.getSource() == this.v.B_buscarMod) {
            System.out.println(this.v.T_Buscador.getText());
            ArrayList<Persona> pers = this.m.buscarPorCorreo(
                    this.v.T_Buscador.getText()
            );
            for (Persona p : pers) {
                this.v.T_nomRemp.setText(p.getNombre());
                this.v.T_apeRemp.setText(p.getApellidos());
                this.v.T_edadRem.setText("" + p.getEdad());
                this.v.T_mailRemp.setText(p.getEmail());
                this.v.T_carreraRemp.setText(p.getCarrera());
                temp = p.getEmail();
            }
        }

        if (e.getSource() == this.v.B_modif) {
            this.m.modificarPersonaEmail(temp, this.v.T_nomRemp.getText(),
                    this.v.T_apeRemp.getText(),
                    Long.parseLong(this.v.T_edadRem.getText()),
                    this.v.T_mailRemp.getText(),
                    this.v.T_carreraRemp.getText()
            );
        }

        if (e.getSource() == this.v.B_buscarElim) {
            System.out.println(this.v.T_Buscador.getText());
            ArrayList<Persona> pers = this.m.buscarPorCorreo(
                    this.v.T_Buscador.getText()
            );
            for (Persona p : pers) {
                this.v.T_nomRemp.setText(p.getNombre());
                this.v.T_apeRemp.setText(p.getApellidos());
                this.v.T_edadRem.setText("" + p.getEdad());
                this.v.T_mailRemp.setText(p.getEmail());
                this.v.T_carreraRemp.setText(p.getCarrera());
                temp = p.getEmail();
            }
        }

        if (e.getSource() == this.v.B_elim) {
            this.m.borrarPersona(this.v.T_apeRemp.getText());
        }

        //-------------------------------------
        if (e.getSource() == this.v.crear) {
            //System.out.println("Si entra Crear");
            this.v.contenedor.removeAll();
            this.v.contenedor.validate();
            this.v.contenedor.add(this.v.crearPersona());
            this.v.contenedor.validate();

            this.v.B_borrar.addActionListener(this);
            this.v.B_guardar.addActionListener(this);

        }

        if (e.getSource() == this.v.buscar) {
            //System.out.println("Si entra Buscar");
            this.v.contenedor.removeAll();
            this.v.contenedor.validate();
            this.v.contenedor.add(this.v.buscarPersona());
            this.v.contenedor.validate();

            this.v.B_borrar.addActionListener(this);
            this.v.B_guardar.addActionListener(this);
            this.v.B_buscarEsp.addActionListener(this);
            this.v.acercade.addActionListener(this);

        }

        if (e.getSource() == this.v.elim) {
            this.v.contenedor.removeAll();
            this.v.contenedor.validate();
            this.v.contenedor.add(this.v.eliminarPersona());
            this.v.contenedor.validate();

            this.v.B_borrar.addActionListener(this);
            this.v.B_buscarElim.addActionListener(this);
            this.v.B_elim.addActionListener(this);

        }

        if (e.getSource() == this.v.modif) {
            //System.out.println("Si entra Modificar");
            this.v.contenedor.removeAll();
            this.v.contenedor.validate();
            this.v.contenedor.add(this.v.modificarPersona());
            this.v.contenedor.validate();

            this.v.B_borrar.addActionListener(this);
            this.v.B_modif.addActionListener(this);
            this.v.B_buscarMod.addActionListener(this);

        }

        if (e.getSource() == this.v.todos) {
            //System.out.println("Si entra Mostrar Todos");
            this.v.contenedor.removeAll();
            this.v.contenedor.validate();
            this.v.contenedor.add(this.v.mostrarTodos());
            this.v.contenedor.validate();

            String todo = "";
            for (Persona p : this.m.buscarTodos()) {
                todo = todo + "Nombre: " + p.getNombre() + "\n"
                        + "Apellido: " + p.getApellidos() + "\n"
                        + "Edad: " + p.getEdad() + "\n"
                        + "Email: " + p.getEmail() + "\n"
                        + "Carrera: " + p.getCarrera() + "\n\n";
            }
            this.v.A_resultados.setText(todo);

        }
        
        if (e.getSource() == this.v.todotabla) {
            //System.out.println("Si entra Mostrar Todos");
            this.v.contenedor.removeAll();
            this.v.contenedor.validate();
            this.v.contenedor.add(this.v.mostrarTabla(this.m.buscarTodosTabla()));
            this.v.contenedor.validate();
         

        }

    }

}
