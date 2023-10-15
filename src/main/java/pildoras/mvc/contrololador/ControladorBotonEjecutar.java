/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.mvc.contrololador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pildoras.mvc.modelo.EjecutaConsultas;
import pildoras.mvc.vista.MarcoMVC;

/**
 *
 * @author Pedro
 */
public class ControladorBotonEjecutar implements ActionListener {

    private final MarcoMVC miFrame;
    private EjecutaConsultas obj = new EjecutaConsultas();
    private ResultSet resultadoConsulta;//almacena el rs de la consulta

    public ControladorBotonEjecutar(MarcoMVC miFrame) {
        super();
        this.miFrame = miFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String seleccionSeccion = (String) miFrame.getSecciones().getSelectedItem();
        String seleccionPais = (String) miFrame.getPaises().getSelectedItem();

        //la llamada devuelve el resultset de la consulta
        resultadoConsulta = obj.consultaBBDD(seleccionSeccion, seleccionPais);

        try {
            //antes de poblar el JTextArea borrarlo con ""
            miFrame.getResultados().setText("");
            //recorrer consulta
            while (resultadoConsulta.next()) {
                /* Como se repite código es más elegante usar un bucle for
                miFrame.getResultados().append(resultadoConsulta.getString(1));
                miFrame.getResultados().append(", ");

                miFrame.getResultados().append(resultadoConsulta.getString(2));
                miFrame.getResultados().append(", ");

                miFrame.getResultados().append(resultadoConsulta.getString(3));
                miFrame.getResultados().append(", ");

                miFrame.getResultados().append(resultadoConsulta.getString(4));
                miFrame.getResultados().append("\n"); */

                //imprimir 4 columnas de la consulta 
                for (int i = 1; i < 5; i++) {
                    miFrame.getResultados().append(resultadoConsulta.getString(i));
                    miFrame.getResultados().append(", ");
                }
                miFrame.getResultados().append("\n");
            }

            //válido hasta video 198, usado para depuración. Ahora da error porque queremos mostrar
            //los resultados de la consulta y no la seleccion de los JCombo
            //miFrame.getResultados().append(obj.consultaBBDD(seleccionSeccion, seleccionPais));
            //miFrame.getResultados().append("\n");
        } catch (SQLException ex) {
            Logger.getLogger(ControladorBotonEjecutar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
