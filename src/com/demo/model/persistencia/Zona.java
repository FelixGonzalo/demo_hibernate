package com.demo.model.persistencia;
// Generated 06/10/2019 10:15:41 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Zona generated by hbm2java
 */
public class Zona  implements java.io.Serializable {


     private int idZona;
     private String descripcion;
     private Set productos = new HashSet(0);

    public Zona() {
    }

	
    public Zona(int idZona, String descripcion) {
        this.idZona = idZona;
        this.descripcion = descripcion;
    }
    public Zona(int idZona, String descripcion, Set productos) {
       this.idZona = idZona;
       this.descripcion = descripcion;
       this.productos = productos;
    }
   
    public int getIdZona() {
        return this.idZona;
    }
    
    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set productos) {
        this.productos = productos;
    }




}


