/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nservlet;

import alumno.Alumno;
import conectordb.ConexionMySQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author PEPE
 */
@WebServlet(name = "NServlet", urlPatterns = {"/NServlet"})
public class NServlet extends HttpServlet {

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
     * arraylist lista alumno que almacena los datos de codi y nom de la 
     * base de dato y así poder pasar la lista al jsp 
     * con request se pasa la lista señalando la rutra del jsp
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Alumno> listaAlumno = new ArrayList();
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.conectar();

        String vSQL = "SELECT * from alumne;";
        Statement st;
        ResultSet rs;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(vSQL);

            while (rs.next()) {
                int cod = rs.getInt("codi");
                String nom = rs.getString("nom");
                Alumno al = new Alumno(cod, nom);
                listaAlumno.add(al);

            }
            request.setAttribute("arraylist", listaAlumno);
            RequestDispatcher a = request.getRequestDispatcher("/index.jsp");
            a.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(NServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * se realiza el query para mostrar alumno y sus tutorias y almacenando esa información en un objeto Alumno
     * que se enviará a un nuevo jsp con request
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.conectar();

        String codi = (String) request.getParameter("select");
        String vSQL = "select alumne.codi as codialumno, alumne.nom as nombalumno, tutoria.nom as tutonombre, assignatura.nom as asignanombre    "
                + "from alumne   "
                + "inner JOIN tutoriaalumne on tutoriaalumne.codiAlumne = alumne.codi  "
                + "inner join tutoria on tutoria.codi = tutoriaalumne.codiTutoria  "
                + "inner join assignatura on assignatura.codi=tutoria.codiAssignatura  "
                + "where alumne.codi=" + codi;
        Statement st;
        ResultSet rs;

        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        try {
            st = cn.createStatement();
            rs = st.executeQuery(vSQL);
            Alumno au = new Alumno();
            while (rs.next()) {
                au.setCodi(rs.getInt("codialumno"));
                au.setNom(rs.getNString("nombalumno"));
                au.setAssignatures(rs.getNString("asignanombre"));
                au.setTutories(rs.getNString("tutonombre"));
                
            }
            request.setAttribute("alumno", au);
            RequestDispatcher a = request.getRequestDispatcher("result.jsp");
            a.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(NServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
//            out.close();
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
