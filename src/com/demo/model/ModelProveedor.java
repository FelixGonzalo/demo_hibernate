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
    public static void createProveedor(Proveedor proveedor) {
        try {
            Session session = iniciaOperacion();
            session.save(proveedor);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
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

    public static void updateProveedor(Proveedor proveedor) {
        try {
            Session session = iniciaOperacion();
            session.update(proveedor);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }

    public static void deleteProveedor(Proveedor proveedor) {
        try {
            Session session = iniciaOperacion();
            session.delete(proveedor);
            terminarOperacion(session);
        } catch (Exception e) {
            mensajeError(e);
        }
    }
}
