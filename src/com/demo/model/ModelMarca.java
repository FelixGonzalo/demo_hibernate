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

    public static void createMarca(Marca marca) {
        try {
            Session session = iniciaOperacion();
            session.save(marca);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
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

    public static void updateMarca(Marca marca) {
        try {
            Session session = iniciaOperacion();
            session.update(marca);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }

    public static void deleteMarca(Marca marca) {
        try {
            Session session = iniciaOperacion();
            session.delete(marca);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }

    public static void main(String[] args) {
        //solo para pruebas
        ModelMarca prueba = new ModelMarca();
        List<Marca> temp = null;
        Marca onodo2 = new Marca();
        onodo2.setIdMarca(2);
        onodo2.setDescripcion("solo es prueba actualida otra vez 2");
        prueba.updateMarca(onodo2);
        temp = null;
        temp = prueba.readMarca();
        for (Marca marca : temp) {
            System.out.println(marca.getIdMarca() + " --> " + marca.getDescripcion());
        }

    }
}
