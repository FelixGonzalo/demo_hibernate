/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.model.ModelMarca;
import com.demo.model.ModelPresentacion;
import com.demo.model.ModelProducto;
import com.demo.model.ModelProveedor;
import com.demo.model.ModelZona;
import com.demo.model.persistencia.Marca;
import com.demo.model.persistencia.Presentacion;
import com.demo.model.persistencia.Producto;
import com.demo.model.persistencia.Proveedor;
import com.demo.model.persistencia.Zona;
import java.util.List;

/**
 *
 * @author Fekilo
 */
public class ControladorProducto extends Controlador{
    public int createProducto(String id, String codigo, String descripcion, String precio, String stock, 
            String iva, String peso, String idMarca, String idPresentacion, String idProveedor, String idZona) {
        int band = 0;
        if (id.equals("") || codigo.equals("") || descripcion.equals("") || precio.equals("") || stock.equals("") || iva.equals("") || peso.equals("") 
                || idMarca.equals("") || idPresentacion.equals("") || idProveedor.equals("") || idZona.equals("")) {
            band = 2;
        } else {
            try {
                Marca marca = ModelMarca.readMarca(Integer.parseInt(idMarca));
                Presentacion presentacion = ModelPresentacion.readPresentacion(Integer.parseInt(idPresentacion));
                Proveedor proveedor = ModelProveedor.readProveedor(Integer.parseInt(idProveedor));
                Zona zona = ModelZona.readZona(Integer.parseInt(idZona));
                
                Producto producto = new Producto(Integer.parseInt(id), marca, presentacion, proveedor, zona, 
                        Integer.parseInt(codigo), descripcion, Double.parseDouble(precio), Integer.parseInt(stock), Integer.parseInt(iva), Double.parseDouble(peso));
                band = ModelProducto.createProducto(producto);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }

    public String[][] readProducto() {
        List<Producto> tpLista = null;
        String[][] productos = null;
        Producto tpProducto = null;
        try {
            tpLista = ModelProducto.readProducto();
            productos = new String[tpLista.size()][11];
            for (int i = 0; i < tpLista.size(); i++) {
                tpProducto = tpLista.get(i);
                productos[i][0] = Integer.toString(tpProducto.getIdProducto());
                productos[i][1] = Integer.toString(tpProducto.getCodigo());
                productos[i][2] = tpProducto.getDescripcionProducto();
                productos[i][3] = Double.toString(tpProducto.getPrecio());
                productos[i][4] = Integer.toString(tpProducto.getStock());
                productos[i][5] = Integer.toString(tpProducto.getIva());
                productos[i][6] = Double.toString(tpProducto.getPeso());
                productos[i][7] = Integer.toString(tpProducto.getMarca().getIdMarca());
                productos[i][8] = Integer.toString(tpProducto.getPresentacion().getIdPresentacion());
                productos[i][9] = Integer.toString(tpProducto.getProveedor().getIdProveedor());
                productos[i][10] = Integer.toString(tpProducto.getZona().getIdZona());
            }
        } catch (Exception e) {
            mensajeError(e);
        }
        return productos;
    }

    public int updateProducto(String id, String codigo, String descripcion, String precio, String stock, 
            String iva, String peso, String idMarca, String idPresentacion, String idProveedor, String idZona) {
        int band = 0;
        if (id.equals("") || codigo.equals("") || descripcion.equals("") || precio.equals("") || stock.equals("") || iva.equals("") || peso.equals("") 
                || idMarca.equals("") || idPresentacion.equals("") || idProveedor.equals("") || idZona.equals("")) {
            band = 2;
        } else {
            try {
                Marca marca = ModelMarca.readMarca(Integer.parseInt(idMarca));
                Presentacion presentacion = ModelPresentacion.readPresentacion(Integer.parseInt(idPresentacion));
                Proveedor proveedor = ModelProveedor.readProveedor(Integer.parseInt(idProveedor));
                Zona zona = ModelZona.readZona(Integer.parseInt(idZona));
                
                Producto producto = new Producto(Integer.parseInt(id), marca, presentacion, proveedor, zona, 
                        Integer.parseInt(codigo), descripcion, Double.parseDouble(precio), Integer.parseInt(stock), Integer.parseInt(iva), Double.parseDouble(peso));
                band = ModelProducto.updateProducto(producto);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }

    public int deleteProducto(String id) {
        int band = 0;
        if (id.equals("")) {
            band = 2;
        } else {
            try {
                //Se utiliza 1 y " " para evitar error con NULL 
                Marca marca = new Marca(1, " ");
                Presentacion presentacion = new Presentacion(1, " ");
                Proveedor proveedor = new Proveedor(1, " ");
                Zona zona = new Zona(1, " ");
                Producto producto = new Producto(Integer.parseInt(id), marca, presentacion, proveedor, zona, 1, " ", 1, 1, 1, 1);
                band = ModelProducto.deleteProducto(producto);
            } catch (Exception e) {
                band = 3;
            }
        }
        return band;
    }
}
