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
public class HorarioxComedor {
    private int Id;
    //Horario horario = new Horario();
    Comedor comedor = new Comedor();
    Persona persona = new Persona();
    
    // hora inicio int
    // fecha reserva = today
    
    

    public HorarioxComedor() {
    }

    public HorarioxComedor(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

   
    public Comedor getComedor() {
        return comedor;
    }

    public void setComedor(Comedor comedor) {
        this.comedor = comedor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "HorarioxComedor{" + "Id=" + Id  + ", comedor=" + comedor + ", persona=" + persona + '}';
    }
    
    
}
