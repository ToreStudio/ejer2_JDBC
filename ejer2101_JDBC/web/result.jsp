<%-- 
    Document   : result
    Created on : 27-oct-2016, 3:13:47
    Author     : PEPE

    1. El método doPost, mediante request.setAttribute("alumno"), envía el ResultSet
       con la información del alumno seleccionado en el index.jsp y mediante un 
       bucle while, va escribiendo la información que encuentra que coincidan con el 
       String que sea igual al nombre del campo de la consulta jquery.

    2. Se crea un input con el valor del código del alumno seleccionado y se envía 
       mediante action al XMLServlet al método doPost, el cual recibirá el valor mediante 
       el request.getAttribute("n1"). Almacenado en un input.

    3. Se ha utilizado css para darle estilo a la información recibida. 

    *pageContext: permite acceo a objetos varios, como request.
    *contextPath: permite cambiar automáticamente la ruta donde esté localizado
    el Servlet, para que peuda ser localizado.
    
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%ResultSet rs = (ResultSet) request.getAttribute("alumno"); %>
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

            /**
            nth-child es una subclase que permite entre otras cosas darle un 
            color diferente a los elementos pares(even) o impares(odd))
            **/
            tr:nth-child(even) {
                background-color: #dddddd;
            }

            .invi {
                display: none;
            }

        </style>
        <title>Servlet NServlet</title>
    </head>
    <body>
    <center><form action="${pageContext.request.contextPath}/XMLServlet" method="POST">
            <center><h1>Información del alumno result.jsp</h1></center>
            <table>
                <tr>
                    <th>Códio</th>
                    <th>Nombre</th>
                    <th>Asignaturas</th>
                    <th>Tutorías</th>
                </tr>

                <% while (rs.next()) {
                        out.print("<tr>");
                        out.print("<td>" + rs.getInt("codialumno") + "</td>");
                        out.print("<td>" + rs.getString("nombalumno") + "</td>");
                        out.print("<td>" + rs.getString("asignanombre") + "</td>");
                        out.print("<td>" + rs.getString("tutonombre") + "</td>");
                        out.print("</tr>");
                %><input class="invi" name="n1" value="<%=rs.getInt("codialumno")%>"/>
                <%}%>    
            </table>
            <br/>
            <br/>
            <center><h1>Pulsa el botón para mostrar y almacenar la información<br/> 
                    de la tabla en un archivo xml</h1></center>
            <input type="submit" value="Guardar">
        </form></center>
</body>
</html>