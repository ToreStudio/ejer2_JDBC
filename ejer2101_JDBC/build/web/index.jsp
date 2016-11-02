<%-- 
    Document   : index
    Created on : 20-oct-2016, 16:00:18
    Author     : PEPE

   1.El ArrayList recibe los nombres y códigos de los alumnos almacenados en el ArrayList 
    del mÃ©todo doGet en el NServlet, gracias a request.getAttribute("arraylist"). 
    Se crea un objeto auxiliar d la clase Alumno y se recorre un bucle for con 
    el tamaÃ±o del ArrayList, permitiendo acceder a los objetos Alumno almacenados.

   2.Una vez seleccionado el alumno con el form mediante method="POST" manda el 
    código del alumno seleccionado al doPost (el doPost recibe el código gracias 
    al request.getAttribute("select"))  del NServlet para hacer la consulta en la 
    base de datos sobre sus asignaturas y tutorias.

--%>
<%@page import="java.util.ArrayList"%>
<%@page import="alumno.Alumno"%>
<%ArrayList listaAlumno = (ArrayList) request.getAttribute("arraylist");%>
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

