package edu.ucentral.comedoresapp.controller;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import edu.ucentral.comedoresapp.model.Comedor;
import edu.ucentral.comedoresapp.model.HorarioxComedor;
import edu.ucentral.comedoresapp.model.Persona;
import edu.ucentral.comedoresapp.model.ResultWrpp;
import edu.ucentral.comedoresapp.model.Zona;
import edu.ucentral.comedoresapp.repository.ComedorJDBC;
import edu.ucentral.comedoresapp.repository.HorarioxComedorJDBC;
import edu.ucentral.comedoresapp.repository.PersonaJDBC;
import edu.ucentral.comedoresapp.repository.ZonaJDBC;
import java.io.IOException;
import static java.lang.System.console;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "PersonaController", urlPatterns = {"/PersonaController"})
public class PersonaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opcion = req.getParameter("Zonavalue");
        System.out.println("opcion get " + opcion);
        if (req.getParameter("accion") != null) {
            String accion = req.getParameter("accion");
            if (accion.equals("Registrar")) {
                try {
                    registrarPersona(req, resp);

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
            }else{
                try {
                    verPersonasComedor(req,resp);
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

        if (req.getParameter("accion") != null) {
            String accion = req.getParameter("accion");
            if (accion.equals("persistirPersona")) {
            }
            try {
                persistirPersona(req, resp);
            } catch (IOException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException | SQLException e) {
            }

        }

    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo(); //To change body of generated methods, choose Tools | Templates.
    }

    private void registrarPersona(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        String opcion = req.getParameter("Zonavalue");
        System.out.println("opcion get registrar" + opcion);

        String nombre = req.getParameter("inputnombre");
        HttpSession session = req.getSession();
        req.setAttribute("inputnombre", nombre);
        List<Zona> zonas = ZonaJDBC.instancia().listarZonas();
        System.out.println("listZonas " + zonas);
        req.setAttribute("listZonas", zonas);
        req.getRequestDispatcher("WEB-INF/comedores/registroPersona.jsp").forward(req, resp);
    }

    private void buscarComedoresXZona(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        /*String idzona = req.getParameter("zona.id");
        String nombreCliente = req.getParameter("inputnombre");
        System.out.println(" o: " + idzona);
        req.setAttribute("inputnombre",nombreCliente);
        req.getRequestDispatcher("WEB-INF/comedores/vercomedores.jsp").forward(req, resp);*/
    }

    private void persistirPersona(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ServletException {

        try {
            String nombre = req.getParameter("inputnombre");
            String apellidos = req.getParameter("inputApellidos");
            int cedula = Integer.valueOf(req.getParameter("inputCedula"));
            String direccion = req.getParameter("inputdireccion");
            String telefono = req.getParameter("inputTelefono");
            int sisbenNum = Integer.valueOf(req.getParameter("inputsisben"));
            String dicapacidad = req.getParameter("CheckDiscapacidad");
            
            dicapacidad = dicapacidad == null ? "false" : "true";
            String conflicto = req.getParameter("Checkconflicto");
            conflicto = conflicto == null ? "false" : "true";

            String habCalle = req.getParameter("Checkhabitante");
            habCalle = habCalle == null ? "false" : "true";

            int opcion = Integer.valueOf(req.getParameter("Zonavalue"));

            Zona zona = new Zona();
            zona.setId(opcion);

            Persona persona = new Persona(cedula, nombre, apellidos, direccion, telefono, sisbenNum, dicapacidad, conflicto, habCalle, zona);

            System.out.println("persona antes del envio: " + persona);
            //String mensaje = PersonaJDBC.instancia().insertarPersona(persona);
            ResultWrpp wrpResp = PersonaJDBC.instancia().insertarPersona(persona);
            
            req.setAttribute("personaRecord", wrpResp.getIdCreado());
            req.setAttribute("mensaje", wrpResp.getStrMensaje());
            req.setAttribute("zonaID", zona.getId());
           
            
            // llamo a buscar comedores por zona para renderizar en la siguiente pagina
            // devolver la lista de comedoresXzona
            
            List<Comedor> comedores = ComedorJDBC.instancia().listarComedores(zona.getId());
            System.out.println("comedores => " + comedores);
            System.out.println("persona => " + persona);
             
            req.setAttribute("comedores", comedores);
            req.setAttribute("objpersona", persona);
            req.getRequestDispatcher("WEB-INF/comedores/verComedores.jsp").forward(req, resp);
            
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException | SQLException e) {
            System.out.println("error=> " + e.getMessage());
        }

    }

    private void verPersonasComedor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("a crear tabla");
        List<HorarioxComedor> registros = HorarioxComedorJDBC.instancia().listarRegistros();
        req.setAttribute("registros", registros);
        System.out.println("registros=> " + registros);
        req.getRequestDispatcher("WEB-INF/comedores/verTablaRegistros.jsp").forward(req, resp);
    }
}
