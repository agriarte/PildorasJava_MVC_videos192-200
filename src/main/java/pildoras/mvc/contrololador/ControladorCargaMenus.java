/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildoras.mvc.contrololador;

import pildoras.mvc.modelo.CargarMenus;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import pildoras.mvc.vista.MarcoMVC;

/**
 *
 * @author Pedro
 */
public class ControladorCargaMenus extends WindowAdapter{
    
    private MarcoMVC miJFrame;
    CargarMenus objCargarMenus = new CargarMenus();
    
    //array que almacena los menus de seccion y paisdeorigen
    private ResultSet[] resultadoCombos;

    public ControladorCargaMenus(MarcoMVC miJFrame) {
        this.miJFrame = miJFrame;
    }
    
    @Override
    public void windowOpened (WindowEvent e) {
       //inicializar array de combos
        resultadoCombos = new ResultSet[2];

        resultadoCombos=objCargarMenus.ejecutaConsultas();


       try {
           //resultadoCombos[0].previous();
           //resultadoCombos[1].previous();
           //solucion rara, este es un programa poco ortodoxo
           miJFrame.getSecciones().addItem(resultadoCombos[0].getString(1));
           miJFrame.getPaises().addItem(resultadoCombos[1].getString(1));

           while (resultadoCombos[0].next()){
               miJFrame.getSecciones().addItem(resultadoCombos[0].getString(1));
           }
           while (resultadoCombos[1].next()){
               miJFrame.getPaises().addItem(resultadoCombos[1].getString(1));
           }
       }catch (Exception ev){
           System.out.println("algun error");
       }

    }
}
