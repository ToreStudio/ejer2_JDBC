<%-- 
    Document   : result
    Created on : 27-oct-2016, 3:13:47
    Author     : PEPE
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="alumno.Alumno"%>
<%@page import="java.sql.ResultSet"%>
<% Alumno aux = (Alumno) request.getAttribute("alumno");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }

        </style>
        <title>Servlet NServlet</title>
    </head>
    <body>
    <center><h1>Información del alumno result.jsp</h1></center>
    <table>
        <tr>
            <th>Códio</th>
            <th>Nombre</th>
            <th>Asignaturas</th>
            <th>Tutorías</th>
        </tr>
        <tr>  
            <td> <% out.print(aux.getCodi());%> </td>
            <td><% out.print(aux.getNom());%> </td>
            <td> <% out.print(aux.getAssignatures());%> </td>
            <td><% out.print(aux.getTutories());%> </td>
        </tr>
    </table>
</body>
</html>