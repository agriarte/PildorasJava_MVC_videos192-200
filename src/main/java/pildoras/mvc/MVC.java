/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pildoras.mvc;

import javax.swing.JFrame;
import pildoras.mvc.vista.MarcoMVC;

/**
 *
 * @author Pedro
 */
public class MVC {

    public static void main(String[] args) {
        MarcoMVC miApp = new MarcoMVC();
        miApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miApp.setVisible(true);

    }
}
