/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.model;

import java.sql.Date;

/**
 *
 * @author CORE I9 RX 5700XT
 */
public class Horario {
    private int Id;
    private String horaInicio;

    public Horario() {
    }

    public Horario(int Id, String horaInicio) {
        this.Id = Id;
        this.horaInicio = horaInicio;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public String toString() {
        return "Horario{" + "Id=" + Id + ", horaInicio=" + horaInicio + '}';
    }
    
}
