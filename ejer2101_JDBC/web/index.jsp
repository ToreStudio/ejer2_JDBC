<%-- 
    Document   : index
    Created on : 20-oct-2016, 16:00:18
    Author     : PEPE
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="alumno.Alumno"%>
<%@page import="java.sql.ResultSet"%>
<% ArrayList listaAlumno = (ArrayList) request.getAttribute("arraylist");  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center><h1>Lista de alumnos</h1></center>
    <center><form method="POST">
            <select name="select">
                <% Alumno aux;
                    for (int i = 0; i < listaAlumno.size(); i++) {
                        aux = (Alumno) listaAlumno.get(i);
                %><option value="<%=aux.getCodi()%> "><%out.println(listaAlumno.get(i).toString()); %></option><%
                    }%>
            </select>
            <input type="submit" value="Buscar">
        </form></center>
    </body>
</html>
