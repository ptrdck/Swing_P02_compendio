/**
 * VentanaDialogo.java
 * 15 nov 2023 12:44:26
 * @author Pedro Patricio Cárdenas Figueroa
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaDialogo.
 */
public class VentanaDialogo extends JDialog{

	 /**
 	 * Instantiates a new ventana dialogo.
 	 *
 	 * @param frame the frame
 	 * @param modal the modal
 	 */
 	public VentanaDialogo(JFrame frame, boolean modal) {
	       
		 super(frame, modal);
	     
		 setTitle("Alta Pisos");
	        
	        
	     
		 ajustarTamanoVentana();  // Ajustar tamaño para ocupar toda la pantalla
	     
		 setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        
	     
		 // Establecer el icono de la ventana
	     
		 ImageIcon icono = new ImageIcon(MiIcon.class.getResource("/recursos/logo1.jpg"));
	     
		 setIconImage(icono.getImage());
	        
	     
		 // Crear instancias de los paneles
	     
		 PanelTitulo panelTitulo = new PanelTitulo();
	     
		 PanelInfoUser panelInfoUser = new PanelInfoUser();
	     
		 PanelInfoVivienda panelInfoVivienda = new PanelInfoVivienda();
	     
		 PanelFichas panelFichas = new PanelFichas(panelInfoUser, panelInfoVivienda);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setViewportView(panelFichas);
		 
		 JPanel panelMix = new JPanel();
		 panelMix.setLayout(new BoxLayout(panelMix, BoxLayout.Y_AXIS));
		 
		 panelMix.add(Box.createVerticalGlue());
		 panelMix.add(panelInfoUser);
		 panelMix.add(panelInfoVivienda);
		 panelMix.add(scrollPane);
		 panelMix.add(Box.createVerticalGlue());
		 panelMix.setAlignmentY(CENTER_ALIGNMENT);
		 
		 JScrollPane scpMix = new JScrollPane();
		 scpMix.setViewportView(panelMix);
		 
		 
		 setLayout(new BorderLayout());
		 
		 this.add(panelTitulo, BorderLayout.NORTH);

		 this.add(scpMix, BorderLayout.CENTER);
		
	     
		 // Establecer la localización relativa al frame principal
	     
		 setLocationRelativeTo(frame);
	    
	 }

	    
	 // Método para mostrar la ventana de diálogo
	 
	 /**
 	 * Mostrar ventana.
 	 */
 	public void mostrarVentana() {
	 
		 setVisible(true);
	    
	 }

	 
	 // Método para ajustar el tamaño de la ventana para que ocupe toda la pantalla
	 
	 /**
 	 * Ajustar tamano ventana.
 	 */
 	private void ajustarTamanoVentana() {
	 
		 // Obtener la resolución de la pantalla
	     
		 Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    
		 setSize(pantalla);
	    
	 }

}
