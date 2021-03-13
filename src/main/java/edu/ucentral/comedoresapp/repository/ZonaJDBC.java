/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.repository;

import edu.ucentral.comedoresapp.model.Zona;
import edu.ucentral.comedoresapp.service.Conexion;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author CORE I9 RX 5700XT
 */
public class ZonaJDBC {

    private static ZonaJDBC zonaJDBC = null;

    public ZonaJDBC() {
    }

    public static ZonaJDBC instancia() {
        if (zonaJDBC == null) {
            zonaJDBC = new ZonaJDBC();
        }
        return zonaJDBC;
    }

    private final String SQL_SELECT = "SELECT * FROM APP.ZONAS order by NOMBREZONA ASC ";

    public List<Zona> listarZonas() throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        List<Zona> listaZona = new ArrayList();
        Zona zona = null;

        conn = Conexion.getConnection();
        stm = conn.prepareStatement(SQL_SELECT);
        rs = stm.executeQuery();

        while (rs.next()) {
            zona = new Zona();
            zona.setId(rs.getInt(1));
            zona.setNombreZona(rs.getString(2));
            zona.setCiudad(rs.getString(3));

            listaZona.add(zona);
        }
        Conexion.closed(conn);
        Conexion.closed(stm);
        Conexion.closed(rs);
        return listaZona;
    }

    private final String SQL_SELECT_ZONA_BY_ID = "SELECT * FROM APP.ZONAS WHERE id=?";

    public Zona buscarZonaporId(int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Zona zona = null;
        
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT_ZONA_BY_ID);
            stm.setInt(1, id);
            System.out.println("stm"+stm);
            rs = stm.executeQuery();
            System.out.println(" rs => "+rs);
            while (rs.next()) {
                zona = new Zona();
                zona.setId(rs.getInt(1));
                zona.setNombreZona(rs.getString(2));
               
            }
       
            Conexion.closed(conn);
            Conexion.closed(stm);
            Conexion.closed(rs);
       
        
        return zona;
    }
}
