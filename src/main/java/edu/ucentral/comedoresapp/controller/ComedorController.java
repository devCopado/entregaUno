/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucentral.comedoresapp.controller;

import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import edu.ucentral.comedoresapp.model.Comedor;
import edu.ucentral.comedoresapp.model.HorarioxComedor;
import edu.ucentral.comedoresapp.model.Persona;
import edu.ucentral.comedoresapp.model.ResultWrpp;
import edu.ucentral.comedoresapp.repository.ComedorJDBC;
import edu.ucentral.comedoresapp.repository.PersonaJDBC;
import edu.ucentral.comedoresapp.repository.HorarioxComedorJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CORE I9 RX 5700XT
 */
@WebServlet(name = "ComedorController", urlPatterns = {"/ComedorController"})
public class ComedorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Seleccionar get =>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("accion") != null) {
            String accion = request.getParameter("accion");
            if(accion.equals("Seleccionar")){
                 String per =request.getParameter("personaRecord");
                 String com = request.getParameter("idComedor");
                 
                 String objCom = request.getParameter("comedores");
               
                 System.out.println("id per =>"+per);
                 System.out.println("id com =>"+com);
                 System.out.println("id objCom =>"+objCom);
                 
           
                try {
                    seleccionarComedor(request,response);
                } catch (SQLException ex) {
                    Logger.getLogger(ComedorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchMethodException ex) {
                    Logger.getLogger(ComedorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ComedorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ComedorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ComedorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(ComedorController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ComedorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void seleccionarComedor(HttpServletRequest request, HttpServletResponse response) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ServletException, IOException, Exception {
        // crear HorarioXcomedor => registro
        
        // validar que al momento de crear el registro no tenga ya la reserva -->OK
        // validar que al momento de seleccionar el comedor tenga la capacidad de ---> 1

        LocalDateTime fechaRegistro = LocalDateTime.now();
        int idComedor = Integer.valueOf(request.getParameter("idComedor"));
        Comedor comedor = ComedorJDBC.instancia().buscarComedor(idComedor);
        
        int idPersona = Integer.valueOf(request.getParameter("personaRecord"));
        Persona persona = PersonaJDBC.instancia().buscarPersona(idPersona);
        
        int ccPersona = persona.getCedula();
        // aca llamo metodos
        Boolean tieneComedor = validarReservaExistente(ccPersona, idComedor);
        Boolean ValidarSiNoHayCupo = validarCupo(idComedor);
        if(tieneComedor || ValidarSiNoHayCupo ){
    
           request.setAttribute("error", tieneComedor);
           request.getRequestDispatcher("WEB-INF/comedores/registrocomedorFallido.jsp").forward(request, response);
            
        }else{
            HorarioxComedor registro = new HorarioxComedor(fechaRegistro,comedor,persona);
            System.out.println("persona antes del envio: " + persona);   
            ResultWrpp wrpResp = HorarioxComedorJDBC.instancia().insertarRegistro(registro,idPersona,idComedor);
            request.setAttribute("idRegistro", wrpResp.getIdCreado());
            request.getRequestDispatcher("WEB-INF/comedores/registroComedor.jsp").forward(request, response);
        }
        
    }
    
    public static boolean validarReservaExistente(int per, int com) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        // valida que no tenga ya una reserva creada
        Boolean isNOk = HorarioxComedorJDBC.instancia().validaReserva(per,com);
        System.out.println("SALES DEL METODO TIENE RESERVA=: " + isNOk);   
        return isNOk;
    }
     public static boolean validarCupo(int com) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException{
        // valida si no hay cupo en el comedor
        Boolean isNOk = HorarioxComedorJDBC.instancia().validarcupo(com);
        System.out.println("SALE DEL METODO validar cupo=: " + isNOk);   
        return isNOk;
    }

}
