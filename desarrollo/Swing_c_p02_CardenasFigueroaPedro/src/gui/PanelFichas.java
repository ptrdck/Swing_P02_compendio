/**
 * PanelFichas.java
 * 25 nov 2023 12:38:22
 * @author Pedro Patricio Cárdenas Figueroa
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelFichas.
 */
public class PanelFichas extends JPanel {

    /** The piu. */
    private PanelInfoUser piu;
    
    /** The piv. */
    private PanelInfoVivienda piv;

    /** The text pane usuario. */
    private JTextPane textPaneUsuario;
    
    /** The text pane vivienda. */
    private JTextPane textPaneVivienda;

    /**
     * Instantiates a new panel fichas.
     *
     * @param piu the piu
     * @param piv the piv
     */
    public PanelFichas(PanelInfoUser piu, PanelInfoVivienda piv) {
    	
    	this.piu = piu;
    	this.piv = piv;
    	
    	
        setLayout(new BorderLayout());

        // Inicialización de paneles internos
        piu = new PanelInfoUser();
        piv = new PanelInfoVivienda();

        // Inicialización de JTextPane para mostrar la información
        textPaneUsuario = new JTextPane();
        textPaneUsuario.setEditable(false);
        textPaneUsuario.setContentType("text/html");
//        textPaneUsuario.setPreferredSize(new Dimension(400,200));
        textPaneUsuario.setBackground(new Color(240,240,240));
        

        textPaneVivienda = new JTextPane();
        textPaneVivienda.setEditable(false);
        textPaneVivienda.setContentType("text/html");
//        textPaneVivienda.setPreferredSize(new Dimension(400,200));
        textPaneVivienda.setBackground(new Color(240,240,240));

        // Configuración del JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Usuario", new JScrollPane(textPaneUsuario)); // Panel vacío, solo para organizar visualmente
        tabbedPane.addTab("Vivienda", new JScrollPane(textPaneVivienda)); // Panel vacío, solo para organizar visualmente

        // Crear el botón Imprimir
        JButton imprimirBtn = new JButton("Imprimir", new MiIcon(20,20, "/recursos/imprimir.png"));
        imprimirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar datos antes de imprimir
                if (validarDatos()) {
                    mostrarInformacion();
                } else {
                    JOptionPane.showMessageDialog(PanelFichas.this, "Falta información por completar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //Crear el boton guardar
        JButton guardarBtn = new JButton("Guardar", new MiIcon(20,20, "/recursos/guardar.png"));
        guardarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar datos antes de guardar
                if (validarDatos()) {
                    JOptionPane.showMessageDialog(PanelFichas.this, "Registro Guardado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(PanelFichas.this, "Falta información por completar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Boton Nuevo
        JButton nuevoBtn = new JButton("Nuevo", new MiIcon(20,20, "/recursos/nuevo.png"));
        nuevoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reiniciarFormulario();
				
			}
        	
        });
        	
 
        
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        
        panelBotones.add(Box.createHorizontalGlue());
        panelBotones.add(imprimirBtn);
        panelBotones.add(guardarBtn);
        panelBotones.add(nuevoBtn);
        panelBotones.add(Box.createHorizontalGlue());
        panelBotones.setAlignmentX(CENTER_ALIGNMENT);
        


        // Agregar componentes al panel
        add(tabbedPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
       
        
    }

    /**
     * Mostrar informacion.
     */
    private void mostrarInformacion() {
        // Obtener la información de los paneles y mostrarla en los JTextArea
        String infoUsuario = piu.obtenerInformacionUsuario();
        String infoVivienda = piv.obtenerInformacionVivienda();
        textPaneUsuario.setText(infoUsuario);
        textPaneVivienda.setText(infoVivienda);
    }
    
    /**
     * Validar datos.
     *
     * @return true, if successful
     */
    private boolean validarDatos() {
        return piu.validarDatos() && piv.validarDatos();
    }
    
    /**
     * Reiniciar formulario.
     */
    private void reiniciarFormulario() {
        piu.reiniciar();
        piv.reiniciar();
        textPaneUsuario.setText("");
        textPaneVivienda.setText("");
    }

    
}