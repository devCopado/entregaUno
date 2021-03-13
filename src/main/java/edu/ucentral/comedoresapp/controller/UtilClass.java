/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CORE I9 RX 5700XT
 */
public class UtilClass {
    private static Statement stm;
    private static String IdCommited;

    public UtilClass() {
    }

    public UtilClass(Statement stm, String IdCommited) {
        UtilClass.stm = stm;
        UtilClass.IdCommited = IdCommited;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        UtilClass.stm = stm;
    }

    public String getIdCommited() {
        return IdCommited;
    }

    public void setIdCommited(String IdCommited) {
        UtilClass.IdCommited = IdCommited;
    }

    @Override
    public String toString() {
        return "UtilClass{" + "stm=" + stm + ", IdCommited=" + IdCommited + '}';
    }
    
    public static String returnId(Statement stm) throws SQLException{
        IdCommited="";
        try(ResultSet generatedKeys = stm.getGeneratedKeys()){
                if(generatedKeys.next()){
                    System.out.println("id----desde util---->" + generatedKeys.getLong(1));
                    IdCommited=(String.valueOf(generatedKeys.getLong(1)));
                   
                }else{
                    throw new SQLException("error al crear persona");
                }
            }
        return IdCommited;
    }
}

