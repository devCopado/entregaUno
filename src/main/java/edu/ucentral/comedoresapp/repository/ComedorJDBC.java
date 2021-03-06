/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.repository;

import edu.ucentral.comedoresapp.model.Comedor;
import java.lang.reflect.InvocationTargetException;
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
    
    private final String SQL_SELECT = "SELECT * FROM comedoresTB ";
    public List<Comedor> listarComedores() throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
         List<Comedor> lstcome =new ArrayList();
         return lstcome;
    }
}
