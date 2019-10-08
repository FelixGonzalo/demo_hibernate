/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.model.ModelZona;
import com.demo.model.persistencia.Zona;
import java.util.List;

/**
 *
 * @author Fekilo
 */
public class ControladorZona extends Controlador{
     public int createZona(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Zona zona = new Zona(Integer.parseInt(id), descripcion);
                band = ModelZona.createZona(zona);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }

    public String[][] readZona() {
        List<Zona> tpLista = null;
        String[][] zonas = null;
        Zona tpZona = null;
        try {
            tpLista = ModelZona.readZona();
            zonas = new String[tpLista.size()][2];
            for (int i = 0; i < tpLista.size(); i++) {
                tpZona = tpLista.get(i);
                zonas[i][0] = Integer.toString(tpZona.getIdZona());
                zonas[i][1] = tpZona.getDescripcion();
            }
        } catch (Exception e) {
            mensajeError(e);
        }
        return zonas;
    }

    public int updateZona(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Zona zona = new Zona(Integer.parseInt(id), descripcion);
                band = ModelZona.updateZona(zona);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }

    public int deleteZona(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Zona zona = new Zona(Integer.parseInt(id), descripcion);
                band = ModelZona.deleteZona(zona);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }
}
