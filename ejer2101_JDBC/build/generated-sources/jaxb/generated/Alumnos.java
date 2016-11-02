//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.5-2 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: PM.10.29 a las 03:58:03 PM CEST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alumno">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="asignatura" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tutoria" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "alumno"
})
@XmlRootElement(name = "alumnos")
public class Alumnos {

    @XmlElement(required = true)
     protected List<Alumnos.Alumno> alumno;

    /**
     * Gets the value of the alumno property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alumno property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlumno().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Alumnos.Alumno }
     * 
     * 
     * @return 
     */
    public List<Alumnos.Alumno> getAlumno() {
        if (alumno == null) {
            alumno = new ArrayList();
        }
        return this.alumno;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="asignatura" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tutoria" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "codigo",
        "nombre",
        "asignatura",
        "tutoria"
    })
    public static class Alumno {

        @XmlElement(required = true)
        protected int codigo;
        @XmlElement(required = true)
        protected String nombre;
        @XmlElement(required = true)
        protected String asignatura;
        @XmlElement(required = true)
        protected String tutoria;

        /**
         * Obtiene el valor de la propiedad codigo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public int getCodigo() {
            return codigo;
        }

        /**
         * Define el valor de la propiedad codigo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodigo(int value) {
            this.codigo = value;
        }

        /**
         * Obtiene el valor de la propiedad nombre.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Define el valor de la propiedad nombre.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNombre(String value) {
            this.nombre = value;
        }

        /**
         * Obtiene el valor de la propiedad asignatura.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAsignatura() {
            return asignatura;
        }

        /**
         * Define el valor de la propiedad asignatura.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAsignatura(String value) {
            this.asignatura = value;
        }

        /**
         * Obtiene el valor de la propiedad tutoria.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTutoria() {
            return tutoria;
        }

        /**
         * Define el valor de la propiedad tutoria.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTutoria(String value) {
            this.tutoria = value;
        }

    }

}
