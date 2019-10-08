/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.model.ModelPresentacion;
import com.demo.model.persistencia.Presentacion;
import java.util.List;

/**
 *
 * @author Fekilo
 */
public class ControladorPresentacion extends Controlador{
    public int createPresentacion(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Presentacion presentacion = new Presentacion(Integer.parseInt(id), descripcion);
                band = ModelPresentacion.createPresentacion(presentacion);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }

    public String[][] readPresentacion() {
        List<Presentacion> tpLista = null;
        String[][] presentaciones = null;
        Presentacion tpPresentacion = null;
        try {
            tpLista = ModelPresentacion.readPresentacion();
            presentaciones = new String[tpLista.size()][2];
            for (int i = 0; i < tpLista.size(); i++) {
                tpPresentacion = tpLista.get(i);
                presentaciones[i][0] = Integer.toString(tpPresentacion.getIdPresentacion());
                presentaciones[i][1] = tpPresentacion.getDescripcion();
            }
        } catch (Exception e) {
            mensajeError(e);
        }
        return presentaciones;
    }

    public int updatePresentacion(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Presentacion presentacion = new Presentacion(Integer.parseInt(id), descripcion);
                band = ModelPresentacion.updatePresentacion(presentacion);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }

    public int deletePresentacion(String id, String descripcion) {
        int band = 0;
        if (id.equals("") || descripcion.equals("")) {
            band = 2;
        } else {
            try {
                Presentacion presentacion = new Presentacion(Integer.parseInt(id), descripcion);
                band = ModelPresentacion.deletePresentacion(presentacion);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }
}
