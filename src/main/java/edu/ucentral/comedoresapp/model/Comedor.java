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
    private String nombre_Comedor;
    private int capacidad_comedor;
    private int hora_inicio;
    private int hora_fin;
    private int cupo_disponible;
    private double porcentajeOcupacion;
    
    Zona zona = new Zona();
    
    public Comedor() {
    }

    public Comedor(int Id, String nombre_Comedor, int capacidad_comedor, int hora_inicio, int hora_fin, int cupo_disponible, double porcentajeOcupacion) {
        this.Id = Id;
        this.nombre_Comedor = nombre_Comedor;
        this.capacidad_comedor = capacidad_comedor;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.cupo_disponible = cupo_disponible;
        this.porcentajeOcupacion = porcentajeOcupacion;
    }
    
    public Comedor( String nombre_Comedor, int capacidad_comedor, int hora_inicio, int hora_fin, int cupo_disponible, double porcentajeOcupacion) {
        
        this.nombre_Comedor = nombre_Comedor;
        this.capacidad_comedor = capacidad_comedor;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.cupo_disponible = cupo_disponible;
        this.porcentajeOcupacion = porcentajeOcupacion;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre_Comedor() {
        return nombre_Comedor;
    }

    public void setNombre_Comedor(String nombre_Comedor) {
        this.nombre_Comedor = nombre_Comedor;
    }

    public int getCapacidad_comedor() {
        return capacidad_comedor;
    }

    public void setCapacidad_comedor(int capacidad_comedor) {
        this.capacidad_comedor = capacidad_comedor;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(int hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getCupo_disponible() {
        return cupo_disponible;
    }

    public void setCupo_disponible(int cupo_disponible) {
        this.cupo_disponible = cupo_disponible;
    }

    public double getPorcentajeOcupacion() {
        return porcentajeOcupacion;
    }

    public void setPorcentajeOcupacion(double porcentajeOcupacion) {
        this.porcentajeOcupacion = porcentajeOcupacion;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Comedor{" + "Id=" + Id + ", nombre_Comedor=" + nombre_Comedor + ", capacidad_comedor=" + capacidad_comedor + ", hora_inicio=" + hora_inicio + ", hora_fin=" + hora_fin + ", cupo_disponible=" + cupo_disponible + ", porcentajeOcupacion=" + porcentajeOcupacion + ", zona=" + zona + '}';
    }
    
    

    

    

    
    

    
   
    
    
}
