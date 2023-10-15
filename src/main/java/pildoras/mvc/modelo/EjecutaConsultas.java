package pildoras.mvc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjecutaConsultas {

    private String seleccion;//usada solo en depuración durante el desarrollo
    private Conexion miConexion;
    private ResultSet rs;
    private PreparedStatement enviConsSeccion;
    private final String CONSULTASECCION = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ?";
    private final String CONSULTAPAIS = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE PAISDEORIGEN = ?";
    private final String CONSULTASECCIONPAIS = "SELECT NOMBREARTICULO, SECCION, PRECIO, PAISDEORIGEN FROM PRODUCTOS WHERE SECCION = ? AND PAISDEORIGEN = ?";

    public EjecutaConsultas() {
        //objeto Conexion para crear la conexion con el método getMiConexion al llamar a consultaBBDD
        miConexion = new Conexion();
    }

    public ResultSet consultaBBDD(String seccion, String pais) {
        //1 crea la conexion
        Connection conecta = miConexion.getMiConexion();

        seleccion = "";//solo para pruebas para imprimir por consola

        System.out.println("consultaBBDD");
        System.out.println(seccion + " , " + pais);

        try {
            //si seccion NO es Todos y el pais = Todos
            if (!seccion.equals("Todas") && pais.equals("Todos")) {
                //2 crea la consulta preparada
                enviConsSeccion = conecta.prepareStatement(CONSULTASECCION);
                enviConsSeccion.setString(1, seccion);//el valor de seccion sustituye al interrogante de la sentencia SQL
                //3 crea el resultSet
                rs = enviConsSeccion.executeQuery();

                seleccion = "Has escogido Seccion";//para consola
            } else if (seccion.equals("Todas") && !pais.equals("Todos")) {
                //2 crea la consulta preparada
                enviConsSeccion = conecta.prepareStatement(CONSULTAPAIS);
                enviConsSeccion.setString(1, pais);//el valor de pais sustituye al interrogante de la sentencia SQL
                //3 crea el resultSet
                rs = enviConsSeccion.executeQuery();
                seleccion = "Has escogido Pais";//para consola
            } else if (!seccion.equals("Todas") && !pais.equals("Todos")) {
                //2 crea la consulta preparada
                enviConsSeccion = conecta.prepareStatement(CONSULTASECCIONPAIS);
                enviConsSeccion.setString(1, seccion);//el valor de seccion sustituye al interrogante de la sentencia SQL
                enviConsSeccion.setString(2, pais);//el valor de pais sustituye al interrogante de la sentencia SQL
                //3 crea el resultSet
                rs = enviConsSeccion.executeQuery();

                seleccion = "Has escogido Seccion y Pais";//para consola
            }
            if (seccion.equals("Todas") && pais.equals("Todos")) {
                seleccion = "No Has escogido nada";//para consola
            }
        } catch (SQLException ex) {
            Logger.getLogger(EjecutaConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.err.println("Valores de los JCombo: " + seleccion);
        return rs;
    }

}
