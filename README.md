#Ejer2_JDBC
#Con esta práctica se pretende mostrar la información almacenada en la base de datos curso.sql, que contiene alumnos con sus respectivas asignaturas y tutorías.
#Las clases utilizadas son:
#•	Alumno: en la cual se almacena la información de la base de datos.
#•	ConexionMySQL: crea la conexión con la base de datos.
#•	NServlet:  maneja las peticiones entre el index.jsp y el result.jsp, medianto los métodos doGet() y doPost().
#•	XMLServlet: maneja la información del result.jsp y la envía a la clase Xmlconverter, que contiene el método objectToXml y creando así el formato xml.
#•	Alumnos: clase generada mediante el jaxB.

#El funcionamiento del proyecto se basa en mostrar una lista de alumnos en el index.jsp y al seleccionar el alumno deseado, tratar la información en el doPost del NServlet y así ejecutar un jquery en el cual mostramos la información del alumno en el result.jsp. Por último , se puede acceder al XMLServlet mediante el botón y así crear el formato xml mediante jaxB.
