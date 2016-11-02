<%-- 
    Document   : resultxml
    Created on : 30-oct-2016, 1:09:55
    Author     : PEPE

    1. Se abre el archivo xml y con el ServletOutputStream se hace un print del 
       contenido del xml.

--%>



<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page XML</title>
    </head>
    <body> 
        <%
            ServletOutputStream stream = null;
            BufferedInputStream buf = null;
            String contextPath = getServletContext().getRealPath("/");
            String xmlFilePath = contextPath + "resultadoalumno.xml";

            stream = response.getOutputStream();
            File xml = new File(xmlFilePath);
            response.setContentType("text/xml");
            //response.addHeader("Content-Disposition", "attachment; filename=resultadoalumno.xml");//guardar archivo
            // response.setContentLength((int) xml.length());
            FileInputStream input = new FileInputStream(xml);
            buf = new BufferedInputStream(input);
            int readBytes;
            //read from the file; write to the ServletOutputStream
            while ((readBytes = buf.read()) != -1) {
                stream.write(readBytes);
            }
            stream.close();
            buf.close();

        %>
    </body> 
</html>