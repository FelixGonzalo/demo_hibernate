/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.persistencia.Zona;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Fekilo
 */
public class ModelZona extends Modelo {
     public static void createZona(Zona zona) {
        try {
            Session session = iniciaOperacion();
            session.save(zona);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }

    public static List<Zona> readZona() {
        List<Zona> zonas = null;
        try {
            Session session = iniciaOperacion();
            zonas = session.createQuery("from Zona").list();
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
        return zonas;
    }

    public static void updateZona(Zona zona) {
        try {
            Session session = iniciaOperacion();
            session.update(zona);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }

    public static void deleteZona(Zona zona) {
        try {
            Session session = iniciaOperacion();
            session.delete(zona);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
}
