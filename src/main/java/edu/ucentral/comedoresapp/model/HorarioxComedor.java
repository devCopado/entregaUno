/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.model;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author CORE I9 RX 5700XT
 */
public class HorarioxComedor {
    
    private int Id;
    private LocalDateTime fecha_reserva; // today
    Comedor comedor = new Comedor();
    Persona persona = new Persona();

    public HorarioxComedor() {
    }

    public HorarioxComedor(int Id, LocalDateTime fecha_reserva) {
        this.Id = Id;
       
        this.fecha_reserva = fecha_reserva;
    }
    
    public HorarioxComedor( LocalDateTime fecha_reserva ,Comedor comedor,Persona persona) {
 
        this.fecha_reserva = fecha_reserva;
        this.comedor = comedor;
        this.persona = persona;
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

    

    public LocalDateTime getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(LocalDateTime fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    @Override
    public String toString() {
        return "HorarioxComedor{" + "Id=" + Id + ", comedor=" + comedor + ", persona=" + persona + ", fecha_reserva=" + fecha_reserva + '}';
    }

    
   
    
    
}
