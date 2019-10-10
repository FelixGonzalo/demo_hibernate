/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.persistencia.Marca;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Fekilo
 */
public class ModelMarca extends Modelo {

    public static int createMarca(Marca marca) {
        int band =0;
        try {
            Session session = iniciaOperacion();
            session.save(marca);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }

    public static List<Marca> readMarca() {
        List<Marca> marcas = null;
        try {
            Session session = iniciaOperacion();
            marcas = session.createQuery("from Marca").list();
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
        return marcas;
    }

    public static int updateMarca(Marca marca) {
        int band =0;
        try {
            Session session = iniciaOperacion();
            session.update(marca);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }

    public static int deleteMarca(Marca marca) {
        int band =0;
        try {
            Session session = iniciaOperacion();
            session.delete(marca);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }
    
    public static Marca readMarca(int idMarca) {
        Marca marca = null;
        try {
            Session session = iniciaOperacion();
            marca = (Marca) session.get(Marca.class, idMarca);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
        return marca;
    }
}
