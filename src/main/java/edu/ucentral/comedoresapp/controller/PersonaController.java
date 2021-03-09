
package edu.ucentral.comedoresapp.controller;

import edu.ucentral.comedoresapp.model.Comedor;
import edu.ucentral.comedoresapp.repository.ComedorJDBC;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersonaController", urlPatterns = {"/PersonaController"})
public class PersonaController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("accion") != null) {
             String accion = req.getParameter("accion");
             if(accion.equals("Registrar")){
                 try {
                     registrarPersona(req,resp);
                 } catch (SQLException ex) {
                     Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (NoSuchMethodException ex) {
                     Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InstantiationException ex) {
                     Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IllegalAccessException ex) {
                     Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IllegalArgumentException ex) {
                     Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (InvocationTargetException ex) {
                     Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo(); //To change body of generated methods, choose Tools | Templates.
    }

    private void registrarPersona(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        req.getRequestDispatcher("WEB-INF/comedores/registroPersona.jsp").forward(req, resp);
    }
    
    
}
