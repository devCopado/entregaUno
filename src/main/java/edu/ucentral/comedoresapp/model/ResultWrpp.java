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
public class ResultWrpp {
    private String strMensaje;
    private String idCreado;

    public ResultWrpp() {
    }

    public String getStrMensaje() {
        return strMensaje;
    }

    public void setStrMensaje(String strMensaje) {
        this.strMensaje = strMensaje;
    }

    public String getIdCreado() {
        return idCreado;
    }

    public void setIdCreado(String idCreado) {
        this.idCreado = idCreado;
    }

    @Override
    public String toString() {
        return "Result{" + "strMensaje=" + strMensaje + ", idCreado=" + idCreado + '}';
    }

   

   
    
    
    
   
}





