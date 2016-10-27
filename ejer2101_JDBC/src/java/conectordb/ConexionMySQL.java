/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conectordb;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *Clase para hacer la conexión con la base de dato
 * @author Guillem
 */
public class ConexionMySQL {

    public String bd = "curso";
    public String login = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost/" + bd;

    public Connection conectar() {
        Connection link = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.login, this.password);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }
}
