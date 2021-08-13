/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.unbosque.clase16grupo16;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;//Capturar Eventos del  Teclado
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Usuario
 */
public class VistaSWING extends JFrame {

    /*
    private int opcion, consultas;
    private long edadRem;
    private String nomRemp, apeRemp, mailRemp, carreraRemp;
     */
    public JTextField T_edadRem, T_nomRemp, T_apeRemp,
            T_mailRemp, T_carreraRemp, T_Buscador;

    public JLabel L_opcion, L_consultas, L_edadRem, L_nomRemp, L_apeRemp,
            L_mailRemp, L_carreraRemp, L_Buscador, L_Titulo;

    public JButton B_borrar, B_guardar, B_elim, B_modif,
            B_buscarEsp, B_buscarMod, B_buscarElim;

    public JTextArea A_resultados;//SCROLBAR

    JScrollPane scrolltxt;

    JTable tabla;

    public JMenuBar barraMenu;
    public JMenu menuOpciones, ayuda;
    public JMenuItem cerrar, crear, modif, elim, buscar, todos,todotabla, acercade;
    public CardLayout card;
    Container contenedor;

    //------------------------------------------------------------
    public VistaSWING() {
        this.setSize(600, 400);
        this.setTitle("Ventana de Reto 5");
        card = new CardLayout();
        contenedor = getContentPane();

        barraMenu = new JMenuBar();

        menuOpciones = new JMenu("Archivo");
        ayuda = new JMenu("Ayuda");

        cerrar = new JMenuItem("Cerrar");
        cerrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                KeyEvent.CTRL_DOWN_MASK));//Acceso directo de Teclado
        crear = new JMenuItem("Crear");
        modif = new JMenuItem("Modificar");
        elim = new JMenuItem("Eliminar");
        buscar = new JMenuItem("Buscar");
        todos = new JMenuItem("Mostrar Todos");
        todotabla= new JMenuItem("Mostrar en Tabla");

        menuOpciones.add(crear);
        menuOpciones.add(buscar);
        menuOpciones.add(todos);
        menuOpciones.add(todotabla);
        menuOpciones.add(modif);
        menuOpciones.add(elim);
        menuOpciones.add(new JSeparator());
        menuOpciones.add(cerrar);
        

        barraMenu.add(menuOpciones);
        acercade = new JMenuItem("Acerca de...");
        acercade.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        ayuda.add(acercade);
        barraMenu.add(ayuda);
      
        this.setJMenuBar(barraMenu);//se usa SETJMENUBAR para que lo agregue ARRIBA
        this.setVisible(true);
        this.setLayout(card);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //-----------------------------------------------------------
    public JPanel crearPersona() {
        JPanel panelCrear = new JPanel();
        panelCrear.setLayout(null);

        //this.setTitle("Crear Persona");
        L_Titulo = new JLabel("Crear Persona");
        L_Titulo.setBounds(225, 0, 150, 20);
        panelCrear.add(L_Titulo);

        T_edadRem = new JTextField();
        T_nomRemp = new JTextField();
        T_apeRemp = new JTextField();
        T_mailRemp = new JTextField();
        T_carreraRemp = new JTextField();

        L_edadRem = new JLabel("Edad:");
        L_nomRemp = new JLabel("Nombre:");
        L_apeRemp = new JLabel("Apellido:");
        L_mailRemp = new JLabel("Email:");
        L_carreraRemp = new JLabel("Carrera:");

        B_borrar = new JButton("Borrar");
        B_guardar = new JButton("Guardar");

        L_nomRemp.setBounds(20, 20, 80, 30);
        L_apeRemp.setBounds(20, 60, 80, 30);
        L_edadRem.setBounds(20, 100, 80, 30);
        L_mailRemp.setBounds(20, 140, 80, 30);
        L_carreraRemp.setBounds(20, 180, 80, 30);

        panelCrear.add(L_nomRemp);
        panelCrear.add(L_apeRemp);
        panelCrear.add(L_edadRem);
        panelCrear.add(L_mailRemp);
        panelCrear.add(L_carreraRemp);

        T_nomRemp.setBounds(100, 20, 200, 30);
        T_apeRemp.setBounds(100, 60, 200, 30);
        T_edadRem.setBounds(100, 100, 50, 30);
        T_mailRemp.setBounds(100, 140, 300, 30);
        T_carreraRemp.setBounds(100, 180, 150, 30);

        panelCrear.add(T_nomRemp);
        panelCrear.add(T_apeRemp);
        panelCrear.add(T_edadRem);
        panelCrear.add(T_mailRemp);
        panelCrear.add(T_carreraRemp);

        B_borrar.setBounds(40, 250, 90, 30);
        B_guardar.setBounds(160, 250, 90, 30);

        panelCrear.add(B_borrar);
        panelCrear.add(B_guardar);

        return panelCrear;
    }

    //-------------------------------------------------
    public JPanel buscarPersona() {
        JPanel panelBuscar = new JPanel();
        panelBuscar.setLayout(null);

        L_Titulo = new JLabel("Buscar Persona");
        L_Titulo.setBounds(100, 0, 150, 20);
        panelBuscar.add(L_Titulo);

        L_Buscador = new JLabel("Buscar:");
        L_Buscador.setBounds(20, 30, 90, 30);
        T_Buscador = new JTextField();
        T_Buscador.setBounds(120, 30, 150, 30);

        B_borrar = new JButton("Borrar");
        B_buscarEsp = new JButton("Buscar");

        B_borrar.setBounds(40, 70, 90, 30);
        B_buscarEsp.setBounds(160, 70, 90, 30);

        panelBuscar.add(B_borrar);
        panelBuscar.add(B_buscarEsp);

        A_resultados = new JTextArea();
        scrolltxt = new JScrollPane(A_resultados);
        scrolltxt.setBounds(20, 120, 360, 250);

        panelBuscar.add(L_Buscador);
        panelBuscar.add(T_Buscador);

        panelBuscar.add(scrolltxt);

        return panelBuscar;
    }

    //---------------------------------------------------------------------
    public JPanel modificarPersona() {
        JPanel panelModificar = new JPanel();
        panelModificar.setLayout(null);

        L_Titulo = new JLabel("Modificar Persona");
        L_Titulo.setBounds(100, 0, 150, 20);
        panelModificar.add(L_Titulo);

        L_Buscador = new JLabel("Buscar Email:");
        L_Buscador.setBounds(20, 30, 90, 30);
        T_Buscador = new JTextField();
        T_Buscador.setBounds(120, 30, 150, 30);

        B_buscarMod = new JButton("Buscar");
        B_buscarMod.setBounds(300, 30, 90, 30);

        panelModificar.add(L_Buscador);
        panelModificar.add(T_Buscador);
        panelModificar.add(B_buscarMod);

        T_edadRem = new JTextField();
        T_nomRemp = new JTextField();
        T_apeRemp = new JTextField();
        T_mailRemp = new JTextField();
        T_carreraRemp = new JTextField();

        L_edadRem = new JLabel("Edad:");
        L_nomRemp = new JLabel("Nombre:");
        L_apeRemp = new JLabel("Apellido:");
        L_mailRemp = new JLabel("Email:");
        L_carreraRemp = new JLabel("Carrera:");

        B_borrar = new JButton("Borrar");
        B_modif = new JButton("Modificar");

        L_nomRemp.setBounds(20, 80, 80, 30);
        L_apeRemp.setBounds(20, 120, 80, 30);
        L_edadRem.setBounds(20, 160, 80, 30);
        L_mailRemp.setBounds(20, 200, 80, 30);
        L_carreraRemp.setBounds(20, 240, 80, 30);

        panelModificar.add(L_nomRemp);
        panelModificar.add(L_apeRemp);
        panelModificar.add(L_edadRem);
        panelModificar.add(L_mailRemp);
        panelModificar.add(L_carreraRemp);

        T_nomRemp.setBounds(130, 80, 80, 30);
        T_apeRemp.setBounds(130, 120, 80, 30);
        T_edadRem.setBounds(130, 160, 50, 30);
        T_mailRemp.setBounds(130, 200, 120, 30);
        T_carreraRemp.setBounds(130, 240, 80, 30);

        panelModificar.add(T_nomRemp);
        panelModificar.add(T_apeRemp);
        panelModificar.add(T_edadRem);
        panelModificar.add(T_mailRemp);
        panelModificar.add(T_carreraRemp);

        B_borrar.setBounds(40, 300, 90, 30);
        B_modif.setBounds(160, 300, 90, 30);

        panelModificar.add(B_borrar);
        panelModificar.add(B_modif);

        return panelModificar;
    }

    //--------------------------------------------------------
    public JPanel mostrarTodos() {
        JPanel panelMostrar = new JPanel();
        panelMostrar.setLayout(null);

        L_Titulo = new JLabel("Todas las Personas");
        L_Titulo.setBounds(100, 0, 150, 20);
        panelMostrar.add(L_Titulo);

        A_resultados = new JTextArea();
        scrolltxt = new JScrollPane(A_resultados);
        scrolltxt.setBounds(20, 70, 360, 250);
        panelMostrar.add(scrolltxt);

        return panelMostrar;
    }

    //-----------------------------------------
    public JPanel eliminarPersona() {
        JPanel panelEliminar = new JPanel();
        panelEliminar.setLayout(null);

        L_Titulo = new JLabel("Borrar Persona");
        L_Titulo.setBounds(100, 0, 150, 20);
        panelEliminar.add(L_Titulo);

        L_Buscador = new JLabel("Buscar por Email:");
        L_Buscador.setBounds(20, 30, 90, 30);
        T_Buscador = new JTextField();
        T_Buscador.setBounds(120, 30, 150, 30);

        B_buscarElim = new JButton("Buscar");
        B_buscarElim.setBounds(300, 30, 90, 30);

        panelEliminar.add(L_Buscador);
        panelEliminar.add(T_Buscador);
        panelEliminar.add(B_buscarElim);

        T_edadRem = new JTextField();
        T_nomRemp = new JTextField();
        T_apeRemp = new JTextField();
        T_mailRemp = new JTextField();
        T_carreraRemp = new JTextField();

        L_edadRem = new JLabel("Edad:");
        L_nomRemp = new JLabel("Nombre:");
        L_apeRemp = new JLabel("Apellido:");
        L_mailRemp = new JLabel("Email:");
        L_carreraRemp = new JLabel("Carrera:");

        B_borrar = new JButton("Borrar");
        B_elim = new JButton("Eliminar");

        L_nomRemp.setBounds(20, 80, 80, 30);
        L_apeRemp.setBounds(20, 120, 80, 30);
        L_edadRem.setBounds(20, 160, 80, 30);
        L_mailRemp.setBounds(20, 200, 80, 30);
        L_carreraRemp.setBounds(20, 240, 80, 30);

        panelEliminar.add(L_nomRemp);
        panelEliminar.add(L_apeRemp);
        panelEliminar.add(L_edadRem);
        panelEliminar.add(L_mailRemp);
        panelEliminar.add(L_carreraRemp);

        T_nomRemp.setBounds(130, 80, 80, 30);
        T_apeRemp.setBounds(130, 120, 80, 30);
        T_edadRem.setBounds(130, 160, 50, 30);
        T_mailRemp.setBounds(130, 200, 120, 30);
        T_carreraRemp.setBounds(130, 240, 80, 30);

        panelEliminar.add(T_nomRemp);
        panelEliminar.add(T_apeRemp);
        panelEliminar.add(T_edadRem);
        panelEliminar.add(T_mailRemp);
        panelEliminar.add(T_carreraRemp);

        B_borrar.setBounds(40, 300, 90, 30);
        B_elim.setBounds(160, 300, 90, 30);

        panelEliminar.add(B_borrar);
        panelEliminar.add(B_elim);

        return panelEliminar;
    }

    //------------------------------------
    public void acercaDe() {

        String mensaje = "Simulacro de Reto 5\n"
                + "Desarrollado por Misael Perilla \u00A9 2021\n"
                + "HIPERION SOFTWORKS TradeMark";
        JOptionPane.showMessageDialog(this, mensaje);

    }


    //--------------------------------------------------------
    public JPanel mostrarTabla(String datos[][]) {
        JPanel panelMostrar = new JPanel();
        panelMostrar.setLayout(null);

        L_Titulo = new JLabel("Todas las Personas");
        L_Titulo.setBounds(100, 0, 150, 20);
        panelMostrar.add(L_Titulo);
              
        String titulos[] = {"Nombre", "Apellido", "Edad", "E-mail", "Carrera"};
        tabla = new JTable(datos, titulos);
        scrolltxt = new JScrollPane(tabla);
        scrolltxt.setBounds(20, 50, 560, 250);
        panelMostrar.add(scrolltxt);

        return panelMostrar;
    }

}
