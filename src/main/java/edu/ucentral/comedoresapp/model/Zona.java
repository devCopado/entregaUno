/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.model;

/**
 *
 * @author CORE I9 RX 5700XT
 */
public class Zona {
    private int Id;
    private String nombreZona;
    private String ciudad;
    private String direccionZona;

    public Zona() {
    }

    public Zona(int Id, String nombreZona, String ciudad, String direccionZona) {
        this.Id = Id;
        this.nombreZona = nombreZona;
        this.ciudad = ciudad;
        this.direccionZona = direccionZona;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccionZona() {
        return direccionZona;
    }

    public void setDireccionZona(String direccionZona) {
        this.direccionZona = direccionZona;
    }

    @Override
    public String toString() {
        return "Zona{" + "Id=" + Id + ", nombreZona=" + nombreZona + ", ciudad=" + ciudad + ", direccionZona=" + direccionZona + '}';
    }

    public static class ZonaJDBC {

        public ZonaJDBC() {
        }
    }
    
    
}
