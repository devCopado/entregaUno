/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.repository;

import edu.ucentral.comedoresapp.model.Comedor;
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
public class ComedorJDBC {

    private static ComedorJDBC comedorJDBC = null;

    private ComedorJDBC() {

    }

    public static ComedorJDBC instancia() {
        if (comedorJDBC == null) {
            comedorJDBC = new ComedorJDBC();
        }
        return comedorJDBC;
    }

    private final String SQL_SELECT_FILTER_bY_ZONA = "SELECT * FROM APP.COMEDORES where zona_comedor=? ";

    public List<Comedor> listarComedores(int id) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Comedor> listaComedores = new ArrayList();
        try {
            Comedor Comedor = null;
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT_FILTER_bY_ZONA);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                Comedor = new Comedor();
                Comedor.setId(rs.getInt(1));
                Comedor.setNombre_Comedor(rs.getString(2));
                Zona zonaQuery = ZonaJDBC.instancia().buscarZonaporId(id);
                Comedor.setZona(zonaQuery);
                Comedor.setHora_inicio(rs.getInt(4));
                Comedor.setHora_fin(rs.getInt(5));
                Comedor.setCapacidad_comedor(rs.getInt(6));
                Comedor.setCupo_disponible(rs.getInt(7));
                Comedor.setPorcentajeOcupacion(rs.getInt(8));
                listaComedores.add(Comedor);
            }
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException | SQLException e) {
            System.out.println(" error Comedores " + e.getMessage());
            System.out.println(" error Comedores " + e.getClass());
        }

        Conexion.closed(conn);
        Conexion.closed(stm);
        Conexion.closed(rs);
        return listaComedores;
    }

    private final String SQL_SELECT_FILTER_bY_ID = "SELECT * FROM APP.COMEDORES where id=? ";

    public Comedor buscarComedor(int id) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Comedor comedor = new Comedor();
        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_SELECT_FILTER_bY_ID);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                comedor.setId(rs.getInt(1));
                comedor.setNombre_Comedor(rs.getString(2));
                Zona zonaQuery = ZonaJDBC.instancia().buscarZonaporId(id);
                comedor.setZona(zonaQuery);
                comedor.setHora_inicio(rs.getInt(4));
                comedor.setHora_fin(rs.getInt(5));
                comedor.setCapacidad_comedor(rs.getInt(6));
                comedor.setCupo_disponible(rs.getInt(7));
                comedor.setPorcentajeOcupacion(rs.getInt(8));

                System.out.println(" get Comedor " + comedor);

            }
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException | SQLException e) {
            System.out.println(" error Comedor " + e.getMessage());
            System.out.println(" error Comedor " + e.getClass());
        }

        Conexion.closed(conn);
        Conexion.closed(stm);
        Conexion.closed(rs);
        return comedor;
    }
    /*
    
     */
    private final String SQL_UPDATE_COMEDOR = "UPDATE APP.COMEDORES SET  cupo_disponible=? WHERE id=?";

    public String modificarComedor(int id) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException {

        System.out.println(" inicio rollup ");
        String mensaje = "";
        Connection conn = null;
        PreparedStatement stm = null;
        int row = 0;

        System.out.println(" try rollup ");
        Comedor com = buscarComedor(id);
        System.out.println(" com encontrado " + com);

        conn = Conexion.getConnection();
        stm = conn.prepareStatement(SQL_UPDATE_COMEDOR);
        int index = 1;

        System.out.println(" antes de capacidad " + com);

        int capacidadTotal = com.getCapacidad_comedor();
        int cupoDisponible;
        System.out.println("capacidadTotal =>" + capacidadTotal);
        
        if(com.getCapacidad_comedor() == com.getCupo_disponible()){
            cupoDisponible = com.getCupo_disponible() - 1;
        }else{
             int deltacapacidad = com.getCapacidad_comedor()- com.getCupo_disponible();
             cupoDisponible = com.getCupo_disponible() - deltacapacidad;
        }
       
        System.out.println("cupoDisponible =>" + cupoDisponible);

        stm.setInt(index++, cupoDisponible);

        stm.setInt(index++, id);

        row = stm.executeUpdate();
        mensaje = "Se actualizo" + row + "registro(s) satisfactoriamente";

        Conexion.closed(conn);
        Conexion.closed(stm);

        return mensaje;
    }
}
