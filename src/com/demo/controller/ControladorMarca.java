/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.model.ModelMarca;
import com.demo.model.persistencia.Marca;
import java.util.List;

/**
 *
 * @author Fekilo
 */
public class ControladorMarca {

    public int createMarca(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Marca marca = new Marca(Integer.parseInt(id), descripcion);
                band = ModelMarca.createMarca(marca);
            } catch (Exception e) {
            }
        }
        return band;
    }

    public String[][] readMarca() {
        List<Marca> tpLista = null;
        String[][] marcas = null;
        Marca tpMarca = null;
        try {
            tpLista = ModelMarca.readMarca();
            marcas = new String[tpLista.size()][2];
            for (int i = 0; i < tpLista.size(); i++) {
                tpMarca = tpLista.get(i);
                marcas[i][0] = Integer.toString(tpMarca.getIdMarca());
                marcas[i][1] = tpMarca.getDescripcion();
            }
        } catch (Exception e) {
            System.out.println("Error readMarca: " + e);
        }
        return marcas;
    }

    public int updateMarca(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Marca marca = new Marca(Integer.parseInt(id), descripcion);
                band = ModelMarca.updateMarca(marca);
            } catch (Exception e) {
            }
        }
        return band;
    }

    public int deleteMarca(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Marca marca = new Marca(Integer.parseInt(id), descripcion);
                band = ModelMarca.deleteMarca(marca);
            } catch (Exception e) {
            }
        }
        return band;
    }

}
