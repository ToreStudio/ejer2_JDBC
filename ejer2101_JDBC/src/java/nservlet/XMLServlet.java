/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nservlet;

import conectordb.ConexionMySQL;
import generated.Alumnos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import xmlconverter.XmlConverter;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author PEPE
 */
@WebServlet(name = "XMLServlet", urlPatterns = {"/XMLServlet"})
public class XMLServlet extends HttpServlet {


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        Alumnos al = new Alumnos();
        XmlConverter xmlC = new XmlConverter();
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.conectar();

        Statement st;
        ResultSet rs;


        try {
            int codi = (int) Integer.parseInt(request.getParameter("n1"));

            String vSQL = "select alumne.codi as codialumno, alumne.nom as nombalumno, tutoria.nom as tutonombre, assignatura.nom as asignanombre    "
                    + "from alumne   "
                    + "inner JOIN tutoriaalumne on tutoriaalumne.codiAlumne = alumne.codi  "
                    + "inner join tutoria on tutoria.codi = tutoriaalumne.codiTutoria  "
                    + "inner join assignatura on assignatura.codi=tutoria.codiAssignatura  "
                    + "where alumne.codi=" + codi;

            st = cn.createStatement();
            rs = st.executeQuery(vSQL);

            //----------------------ruta del archivo----------------------------
            String contextPath = getServletContext().getRealPath("/");
            String xmlFilePath = contextPath + "resultadoalumno.xml";
            //System.out.println("Archivo guardado en la ruta: "+ xmlFilePath);
            File myfile = new File(xmlFilePath);
            //-------------------------fin ruta del archivo---------------------

            while (rs.next()) {
                Alumnos.Alumno alumnoJAXB = new Alumnos.Alumno();

                int cod = rs.getInt("codialumno");
                alumnoJAXB.setCodigo(cod);

                String nomalu = rs.getString("nombalumno");
                alumnoJAXB.setNombre(nomalu);

                String asig = rs.getString("asignanombre");
                alumnoJAXB.setAsignatura(asig);

                String tut = rs.getString("tutonombre");
                alumnoJAXB.setTutoria(tut);
                
                al.getAlumno().add(alumnoJAXB);
                xmlC.objectToXml(al, myfile);
            }


            RequestDispatcher a = request.getRequestDispatcher("/resultxml.jsp");
            a.forward(request, response);

        } catch (IOException ioe) {
//            throw new ServletException(ioe.getMessage());

        } catch (NumberFormatException e) {
        } catch (SQLException ex) {
            Logger.getLogger(XMLServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
