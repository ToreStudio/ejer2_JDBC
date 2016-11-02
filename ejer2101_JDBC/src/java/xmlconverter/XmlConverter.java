/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlconverter;

import generated.Alumnos;
import java.io.File;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author PEPE
 */
public class XmlConverter {

    public XmlConverter() {
    }

    public String objectToXml(Alumnos alu) {
            String al="";
        try {
            
            // Instanciamos el contexto, indicando la clase que será el RootElement.
            JAXBContext jaxbContext = JAXBContext.newInstance(Alumnos.class);
            // Creamos un Marshaller, que es la clase capaz de convertir nuestro java bean
            // en una cadena XML
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Optional
            // Indicamos que vamos a querer el XML con un formato amigable (saltos de linea,
            // sangrado, etc)
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            //Do the job
            jaxbMarshaller.marshal(alu, sw);

            //Optional: output pretty printed
            // Hacemos la conversión llamando al método marshal, pasando una instancia del java
            // bean que quermos convertir a XML y un OutpuStream donde queramos que salga el XML,
            // en esta caso, la salida estándar. Podría ser un fichero o cualquier otro Stream.
            //System.out.println("objectToXml print: ");
            // jaxbMarshaller.marshal(alu, System.out);
            al= sw.toString();
        } catch (JAXBException e) {
            System.out.println("objectToXml error: " + e.getMessage());
        } return al;
    }
}
