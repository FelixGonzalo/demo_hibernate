/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.persistencia.Producto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Fekilo
 */
public class ModelProducto extends Modelo {

    public void createProducto(Producto producto) {
        try {
            Session session = iniciaOperacion();
            session.save(producto);
            terminarOperacion(session);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public List<Producto> readProducto() {
        List<Producto> productos = null;
        try {
            Session session = iniciaOperacion();
            productos = session.createQuery("from Producto").list();
            terminarOperacion(session);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return productos;
    }

    public void updateProducto(Producto producto) {
        try {
            Session session = iniciaOperacion();
            session.update(producto);
            terminarOperacion(session);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public void deleteProducto(Producto producto) {
        try {
            Session session = iniciaOperacion();
            session.delete(producto);
            terminarOperacion(session);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    public Producto readProducto(int idProducto) {
        Producto producto = null;
        try {
            Session session = iniciaOperacion();
            producto = (Producto) session.get(Producto.class, idProducto);
            terminarOperacion(session);

        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return producto;
    }
}
