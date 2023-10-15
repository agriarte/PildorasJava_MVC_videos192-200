package pildoras.mvc.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import pildoras.mvc.contrololador.ControladorBotonEjecutar;
import pildoras.mvc.contrololador.ControladorCargaMenus;

public class MarcoMVC extends JFrame{
    
    private JComboBox secciones,paises;
    private JTextArea resultados;

    public MarcoMVC() {
        setTitle ("Consulta Artículos");
        setBounds(500, 300, 400, 300);
        
        //CREACION de JPanel en zona Norte, se insertan 2 JComboBox
        //Un borderlayout tiene zonas N,S,E,O y CENTRO
        setLayout(new BorderLayout());
        
        JPanel menus = new JPanel();
        menus.setLayout(new FlowLayout());
        
        secciones = new JComboBox();
        secciones.addItem("Todas");
        
        paises = new JComboBox();
        paises.addItem("Todos");
        
        menus.add(secciones);
        menus.add(paises);
        
        add(menus,BorderLayout.NORTH);
        
        //CREACION de JTextArea para mostrar resultados en zona centro
        resultados = new JTextArea(4, 50);
        add (resultados,BorderLayout.CENTER);
        
        //CREACION de JButton en zona sur y a la escucha 
        JButton botonaccion= new JButton("Buscar");
        botonaccion.addActionListener(new ControladorBotonEjecutar(this));
        add (botonaccion, BorderLayout.SOUTH);
            
        addWindowListener(new ControladorCargaMenus(this));
             
    }

    public JComboBox getSecciones() {
        return secciones;
    }

    public void setSecciones(JComboBox secciones) {
        this.secciones = secciones;
    }

    public JComboBox getPaises() {
        return paises;
    }

    public void setPaises(JComboBox paises) {
        this.paises = paises;
    }

    public JTextArea getResultados() {
        return resultados;
    }

    public void setResultados(JTextArea resultados) {
        this.resultados = resultados;
    }
   
    
    
}
