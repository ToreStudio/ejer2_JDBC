/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumno;

/**
 *clase alumno con sus getters y setters
 * @author PEPE
 */
public class Alumno {

    int codi;
    String nom="", assignatures="", tutories="";

    /**
     * constructor con los valores código y nombre del alumno para poder almacenar los datos de la tabla
     * alumne en un arraylist
     * @param codi
     * @param nom 
     */
    public Alumno(int codi, String nom) {
        this.codi = codi;
        this.nom = nom;

    }

    /**
     * Constructor vacio para crear nuevos objetos de la clase alumno
     */
    public Alumno() {
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAssignatures() {
        return assignatures;
    }

    public void setAssignatures(String assignatures) {
        this.assignatures += "  " + assignatures + ", ";
    }

    public String getTutories() {
        return tutories;
    }

    public void setTutories(String tutories) {
        this.tutories += " " + tutories + ", ";
    }

    @Override
    public String toString() {
        return nom;
    }

}
