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
public class Persona {
    
    private int Id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String movil;
    private int numeroSisben;

    public Persona() {
    }

    public Persona(int Id, String cedula, String nombre, String apellido, String direccion, String movil, int numeroSisben) {
        this.Id = Id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.movil = movil;
        this.numeroSisben = numeroSisben;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public int getNumeroSisben() {
        return numeroSisben;
    }

    public void setNumeroSisben(int numeroSisben) {
        this.numeroSisben = numeroSisben;
    }

    @Override
    public String toString() {
        return "Persona{" + "Id=" + Id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", movil=" + movil + ", numeroSisben=" + numeroSisben + '}';
    }
    
    
}

