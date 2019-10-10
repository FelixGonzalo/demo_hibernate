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
     public static int createZona(Zona zona) {
        int band =0;
        try {
            Session session = iniciaOperacion();
            session.save(zona);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
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

    public static int updateZona(Zona zona) {
        int band =0;
        try {
            Session session = iniciaOperacion();
            session.update(zona);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }

    public static int deleteZona(Zona zona) {
        int band =0;
        try {
            Session session = iniciaOperacion();
            session.delete(zona);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }
    
    public static Zona readZona(int idZona) {
        Zona zona = null;
        try {
            Session session = iniciaOperacion();
            zona = (Zona) session.get(Zona.class, idZona);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
        return zona;
    }
}
