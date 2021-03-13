/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.repository;

import edu.ucentral.comedoresapp.controller.UtilClass;
import edu.ucentral.comedoresapp.model.Comedor;
import edu.ucentral.comedoresapp.model.Persona;
import edu.ucentral.comedoresapp.model.ResultWrpp;
import edu.ucentral.comedoresapp.model.Zona;
import edu.ucentral.comedoresapp.service.Conexion;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CORE I9 RX 5700XT
 */
public class PersonaJDBC {

    private static PersonaJDBC personaJDBC = null;

    private PersonaJDBC() {

    }

    public static PersonaJDBC instancia() {
        if (personaJDBC == null) {
            personaJDBC = new PersonaJDBC();
        }
        return personaJDBC;
    }

    private final String SQL_INSERT = "INSERT INTO APP.PERSONAS (cedula, nombre, apellido, direccion, movil,numerosisben,personaendiscapacidad,victimaconflicto,habitantedecalle,zona_persona) values (?,?,?,?,?,?,?,?,?,?)";
    //Persona(cedula, nombre,apellidos, direccion, telefono, sisbenNum,dicapacidad,conflicto,habCalle); 

    public ResultWrpp insertarPersona(Persona persona) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultWrpp wrp= new ResultWrpp() ;
        
        int row = 0;
        try {
            System.out.println("  persona" + persona);
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT,stm.RETURN_GENERATED_KEYS);
            int index = 1;
            
             System.out.println("TODA LA PEOPLE: " + persona.getZona().getId());
            
            stm.setString(index++, String.valueOf(persona.getCedula()));
            stm.setString(index++, persona.getNombre());
            stm.setString(index++, persona.getApellido());
            stm.setString(index++, persona.getDireccion());
            stm.setString(index++, persona.getMovil());
            stm.setInt(index++, persona.getNumeroSisben());
            stm.setString(index++, persona.getPersonaEnDiscapacidad());
            stm.setString(index++, persona.getVictimaConflicto());
            stm.setString(index++, persona.getHabitanteDeCalle());
            stm.setInt(index++, persona.getZona().getId());

            row = stm.executeUpdate();

            wrp.setStrMensaje("Se insertó" + row + "registro(s) satisfactoriamente") ;

            String idCommited = UtilClass.returnId(stm);
            wrp.setIdCreado(idCommited);

        } catch (SQLException e) {
            System.out.println("Error mensaje-------->" + e.getMessage());
            mensaje = "Error: " + e.getMessage();
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
        }

        return wrp;
    }
    private final String SQL_SELECT_FILTER_bY_ID = "SELECT * FROM APP.PERSONAS where ID=?";
    public Persona buscarPersona(int id) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Persona persona = new Persona();
        try {

            
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT_FILTER_bY_ID);
            stm.setInt(1, id);
            
           
            
            rs = stm.executeQuery();

            while (rs.next()) {
                
                persona.setId(rs.getInt(1));
                persona.setCedula(rs.getInt(2));
                persona.setNombre(rs.getString(3));
                persona.setApellido(rs.getString(4));
                persona.setDireccion(rs.getString(5));
                persona.setMovil(rs.getString(6));
                persona.setNumeroSisben(rs.getInt(7));
                persona.setPersonaEnDiscapacidad(rs.getString(8));
                persona.setVictimaConflicto(rs.getString(9));
                persona.setHabitanteDeCalle(rs.getString(10));
                
                
                System.out.println(" ----------> ****** get Persona "+persona);
                
            }
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException | SQLException e) {
            System.out.println(" error Comedor "+e.getMessage());
            System.out.println(" error Comedor "+e.getClass());
        }

        Conexion.closed(conn);
        Conexion.closed(stm);
        Conexion.closed(rs);
        return persona;
    }

}
