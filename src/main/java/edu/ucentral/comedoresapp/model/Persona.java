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
    private int cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String movil;
    private int numeroSisben;
    private String personaEnDiscapacidad;
    private String victimaConflicto;
    private String habitanteDeCalle;
    
    Comedor comedor = new Comedor();
    Zona zona = new Zona();

    public Persona() {
    }

    public Persona(int Id, int cedula, String nombre, String apellido, String direccion, String movil, int numeroSisben) {
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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
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

    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public String getPersonaEnDiscapacidad() {
        return personaEnDiscapacidad;
    }

    public void setPersonaEnDiscapacidad(String personaEnDiscapacidad) {
        this.personaEnDiscapacidad = personaEnDiscapacidad;
    }

    public String getVictimaConflicto() {
        return victimaConflicto;
    }

    public void setVictimaConflicto(String victimaConflicto) {
        this.victimaConflicto = victimaConflicto;
    }

    public String getHabitanteDeCalle() {
        return habitanteDeCalle;
    }

    public void setHabitanteDeCalle(String habitanteDeCalle) {
        this.habitanteDeCalle = habitanteDeCalle;
    }

    @Override
    public String toString() {
        return "Persona{" + "Id=" + Id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", movil=" + movil + ", numeroSisben=" + numeroSisben + ", comedor=" + comedor + ", zona=" + zona + ", personaEnDiscapacidad=" + personaEnDiscapacidad + ", victimaConflicto=" + victimaConflicto + ", habitanteDeCalle=" + habitanteDeCalle + '}';
    }
    
    
    

    

  
    
    
}

