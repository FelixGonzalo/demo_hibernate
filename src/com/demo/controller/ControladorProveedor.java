/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.model.ModelProveedor;
import com.demo.model.persistencia.Proveedor;
import java.util.List;

/**
 *
 * @author Fekilo
 */
public class ControladorProveedor extends Controlador{
    public int createProveedor(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Proveedor proveedor = new Proveedor(Integer.parseInt(id), descripcion);
                band = ModelProveedor.createProveedor(proveedor);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }

    public String[][] readProveedor() {
        List<Proveedor> tpLista = null;
        String[][] proveedores = null;
        Proveedor tpProveedor = null;
        try {
            tpLista = ModelProveedor.readProveedor();
            proveedores = new String[tpLista.size()][2];
            for (int i = 0; i < tpLista.size(); i++) {
                tpProveedor = tpLista.get(i);
                proveedores[i][0] = Integer.toString(tpProveedor.getIdProveedor());
                proveedores[i][1] = tpProveedor.getDescripcion();
            }
        } catch (Exception e) {
            mensajeError(e);
        }
        return proveedores;
    }

    public int updateProveedor(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                 Proveedor proveedor = new Proveedor(Integer.parseInt(id), descripcion);
                band = ModelProveedor.updateProveedor(proveedor);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }

    public int deleteProveedor(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                 Proveedor proveedor = new Proveedor(Integer.parseInt(id), descripcion);
                band = ModelProveedor.deleteProveedor(proveedor);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }
}
