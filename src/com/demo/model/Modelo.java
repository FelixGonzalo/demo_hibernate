/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Fekilo
 */
public class Modelo {

    public static Session iniciaOperacion() {
        Session session = null;
        try {
            SessionFactory sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Session fallida: " + e);
        }
        return session;
    }

    public static void terminarOperacion(Session session) {
        session.getTransaction().commit();
        session.flush();
        session.close();
    }
    
    public static void mensajeError(Exception e) {
       JOptionPane.showMessageDialog(null, "Error en Modelo: " + e);
    }

}
