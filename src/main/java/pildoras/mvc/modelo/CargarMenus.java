/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.mvc.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pedro
 */
public class CargarMenus {
    private final Conexion miConexion;
    private ResultSet[] resultadosConsultas;
    //ATENTO: se crea instancia de conexion para llamar a su método getConexion a través de un método creado en esta clase,
    //llamado ejecutaConsultas();

    public CargarMenus() {
        miConexion = new Conexion();
    }
    public ResultSet[] ejecutaConsultas() {
        Connection accesoBBDD = miConexion.getMiConexion();

        ResultSet resSec = null;
        ResultSet resPais = null;

        try {
            //ResultSet de seccion sin repetir por usar predicado DISTINCT O DISTINCTROW
            //el result contendrá solo la columna especificada, seccion. A las columnas del result se accede por indice
            Statement seccionesSt = accesoBBDD.createStatement();
            resSec= seccionesSt.executeQuery("SELECT DISTINCT SECCION FROM productos");
            Statement paisesSt = accesoBBDD.createStatement();
            resPais= paisesSt.executeQuery("SELECT DISTINCT PAISDEORIGEN FROM productos");

            //adelantar una posicion para luego atrasar. ???? cosa rara

            resSec.next();
            resPais.next();

            resultadosConsultas = new ResultSet[2];
            resultadosConsultas[0]= resSec;
            resultadosConsultas[1]= resPais;

            System.out.println("resultadosconsultas[0]= " +  resultadosConsultas[0].getString(1));
            System.out.println("resultadosconsultas[1]= " +  resultadosConsultas[1].getString(1));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultadosConsultas;
    }
}
