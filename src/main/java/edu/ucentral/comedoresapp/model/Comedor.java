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
public class Comedor {
    private int Id;
    private String Nombre_comedor;
    private int capacidad_comedor;
    Zona zona =new Zona();

    public Comedor() {
    }

    public Comedor(int Id, String Nombre_comedor, int capacidad_comedor) {
        this.Id = Id;
        this.Nombre_comedor = Nombre_comedor;
        this.capacidad_comedor = capacidad_comedor;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre_comedor() {
        return Nombre_comedor;
    }

    public void setNombre_comedor(String Nombre_comedor) {
        this.Nombre_comedor = Nombre_comedor;
    }

    public int getCapacidad_comedor() {
        return capacidad_comedor;
    }

    public void setCapacidad_comedor(int capacidad_comedor) {
        this.capacidad_comedor = capacidad_comedor;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Comedor{" + "Id=" + Id + ", Nombre_comedor=" + Nombre_comedor + ", capacidad_comedor=" + capacidad_comedor + ", zona=" + zona + '}';
    }
    
    
}
