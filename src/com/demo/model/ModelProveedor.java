/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.persistencia.Proveedor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Fekilo
 */
public class ModelProveedor extends Modelo{
    public static int createProveedor(Proveedor proveedor) {
        int band =0;
        try {
            Session session = iniciaOperacion();
            session.save(proveedor);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }

    public static List<Proveedor> readProveedor() {
        List<Proveedor> proveedores = null;
        try {
            Session session = iniciaOperacion();
            proveedores = session.createQuery("from Proveedor").list();
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
        return proveedores;
    }

    public static int updateProveedor(Proveedor proveedor) {
        int band =0;
        try {
            Session session = iniciaOperacion();
            session.update(proveedor);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }

    public static int deleteProveedor(Proveedor proveedor) {
        int band =0;
        try {
            Session session = iniciaOperacion();
            session.delete(proveedor);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }
    
    public static Proveedor readProveedor(int idProveedor) {
        Proveedor proveedor = null;
        try {
            Session session = iniciaOperacion();
            proveedor = (Proveedor) session.get(Proveedor.class, idProveedor);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
        return proveedor;
    }
}
