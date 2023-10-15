/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.mvc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro
 */
public class Conexion {

    public static final String URL = "jdbc:mysql://localhost:3306/gestionpedidos";
    public static final String USER = "root";
    public static final String PASSWORD = "";

    Connection miConexion = null;

    public Conexion() {

    }

    public Connection getMiConexion() {

        try {
            miConexion = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return miConexion;
    }
}
