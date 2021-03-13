/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.repository;

import edu.ucentral.comedoresapp.controller.UtilClass;
import edu.ucentral.comedoresapp.model.Comedor;
import edu.ucentral.comedoresapp.model.HorarioxComedor;
import edu.ucentral.comedoresapp.model.Persona;
import edu.ucentral.comedoresapp.model.ResultWrpp;
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
public class HorarioxComedorJDBC {

    private static HorarioxComedorJDBC horarioxComedorJDBC = null;

    private HorarioxComedorJDBC() {

    }

    public static HorarioxComedorJDBC instancia() {
        if (horarioxComedorJDBC == null) {
            horarioxComedorJDBC = new HorarioxComedorJDBC();
        }
        return horarioxComedorJDBC;
    }

    private final String SQL_INSERT = "INSERT INTO APP.REGISTRO (fecharegistro, persona, comedor ) values (?,?,?)";

    public ResultWrpp insertarRegistro(HorarioxComedor registro, int idPersona, int idComedor) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultWrpp wrp = new ResultWrpp();

        int row = 0;
        try {
            System.out.println("  registro" + registro);
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT, stm.RETURN_GENERATED_KEYS);
            int index = 1;

            stm.setString(index++, String.valueOf(registro.getFecha_reserva()));
            //Persona p = PersonaJDBC.instancia().buscarPersona(registro.getComedor().getId());
            //System.out.println("p------>" + p);
            stm.setInt(index++, idPersona);
            stm.setInt(index++, idComedor);
            row = stm.executeUpdate();

            wrp.setStrMensaje("Se insertó" + row + "registro(s) satisfactoriamente");

            String idCommited = UtilClass.returnId(stm);
            wrp.setIdCreado(idCommited);

            // llamo a actualizar la tabla de comedores
            String rollupComedores = ComedorJDBC.instancia().modificarComedor(idComedor);

        } catch (SQLException e) {
            System.out.println("Error mensaje-------->" + e.getMessage());
            mensaje = "Error: " + e.getMessage();
        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
        }

        return wrp;
    }

    private final String SQL_SELECT_validaReserva = "SELECT APP.REGISTRO.PERSONA,APP.REGISTRO.COMEDOR,APP.PERSONAS.CEDULA FROM APP.REGISTRO INNER JOIN APP.PERSONAS ON APP.REGISTRO.PERSONA =APP.PERSONAS.ID WHERE APP.PERSONAS.CEDULA=? AND APP.REGISTRO.COMEDOR=?";

    public Boolean validaReserva(int per, int com) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        HorarioxComedor registro = null;
        
        Boolean IsNOk=false;
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT_validaReserva);
            stm.setInt(1, per);//PERSONA
            stm.setInt(2, com);//COMEDOR
            
            rs = stm.executeQuery();
            int row=0;
            while (rs.next()) {
              row++;
              if(row>=1){
                  System.out.println("ya esta registrado!!");
                  IsNOk = true;
                  break;
              }
            }
        } catch (SQLException e) {

        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }

        return IsNOk;
    }
    private final String SQL_SELECT_valida_cupo = "SELECT COUNT(id) FROM APP.COMEDORES WHERE id=? AND CAPACIDAD_COMEDOR>=1";
    public Boolean validarcupo(int id) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
       Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        HorarioxComedor registro = null;
        
        Boolean IsNOk=false;
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT_valida_cupo);
            stm.setInt(1, id);//PERSONA
            
            
            rs = stm.executeQuery();
            int row=0;
            while (rs.next()) {
              String conteo =rs.getString(1);
              System.out.println("conteo!!"+conteo);
            }
        } catch (SQLException e) {

        } finally {
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
        }

        return IsNOk;
    }
    private final String SQL_SELECT_LISTAR_REGISTROS = "SELECT APP.REGISTRO.*,APP.PERSONAS.*,APP.COMEDORES.* FROM APP.REGISTRO INNER JOIN APP.PERSONAS ON APP.REGISTRO.PERSONA = APP.PERSONAS.ID INNER JOIN APP.COMEDORES ON APP.REGISTRO.COMEDOR = APP.COMEDORES.ID ";
    public List<HorarioxComedor> listarRegistros() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
         Connection conn =null;
        PreparedStatement stm =null;
        ResultSet rs = null;
        List<HorarioxComedor> listaRegistros = new ArrayList();
        HorarioxComedor registro = null;
        try{
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT_LISTAR_REGISTROS);
            rs =  stm.executeQuery();
            while(rs.next()){
                registro = new HorarioxComedor();
                registro.setId(rs.getInt(1));
                Persona p = PersonaJDBC.instancia().buscarPersona(rs.getInt(3));
                Comedor c = ComedorJDBC.instancia().buscarComedor(rs.getInt(4));
                registro.setComedor(c);
                registro.setPersona(p);
                listaRegistros.add(registro);
            }
            
        }catch(SQLException e){
            
        }finally{
           Conexion.closed(conn);
           Conexion.closed(stm);
           Conexion.closed(rs);
        }
        return listaRegistros; 
    }
}
