/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.controller;



import edu.ucentral.comedoresapp.model.Zona;
import edu.ucentral.comedoresapp.repository.ZonaJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CORE I9 RX 5700XT
 */
@WebServlet(name = "registroController", urlPatterns = {"/registroController"})
public class registroController extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          if (request.getParameter("accion") != null) {
             String accion = request.getParameter("accion");
             if(accion.equals("listarZonas")){
                 try{
                     obtenerZonas(request,response);
                 }
                 catch(Exception e){
                 }
             }
          }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void obtenerZonas(HttpServletRequest request, HttpServletResponse response) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
       List<Zona> zonas = ZonaJDBC.instancia().listarZonas();
        request.setAttribute("listZonas", zonas);
        //response.sendRedirect("registroController");
        //request.getRequestDispatcher("WEB-INF/estudiantes/listaEstudiantes.jsp").forward(request, response);
        
        //request.setAttribute("estudiantes", estudiantes);
        //request.getRequestDispatcher("WEB-INF/estudiantes/listaEstudiantes.jsp").forward(request, response);
    }

}
