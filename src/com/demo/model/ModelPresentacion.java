/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.persistencia.Presentacion;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Fekilo
 */
public class ModelPresentacion extends Modelo{
    public static void createPresentacion(Presentacion presentacion) {
        try {
            Session session = iniciaOperacion();
            session.save(presentacion);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }

    public static List<Presentacion> readPresentacion() {
        List<Presentacion> presentaciones = null;
        try {
            Session session = iniciaOperacion();
            presentaciones = session.createQuery("from Presentacion").list();
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
        return presentaciones;
    }

    public static void updatePresentacion(Presentacion presentacion) {
        try {
            Session session = iniciaOperacion();
            session.update(presentacion);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }

    public static void deletePresentacion(Presentacion presentacion) {
        try {
            Session session = iniciaOperacion();
            session.delete(presentacion);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
}
