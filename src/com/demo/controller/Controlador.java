/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import javax.swing.JOptionPane;

/**
 *
 * @author Fekilo
 */
public class Controlador {
    public static void mensajeError(Exception e) {
       JOptionPane.showMessageDialog(null, "Error en Controlador: " + e);
    }
}
