/**
 * Ventana.java
 * 15 nov 2023 10:27:24
 * @author Pedro Patricio Cárdenas Figueroa
 */
package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;



// TODO: Auto-generated Javadoc
/**
 * The Class VentanaPrincipal.
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
	
	/** The barra principal. */
	JMenuBar barraPrincipal;
	
	/** The ayuda. */
	JMenu archivo, registro, ayuda;
	
	/** The acerca de. */
	JMenuItem salir, altaPisos, bajaPisos, acercaDe;
	
	/** The baja. */
	JButton alta, baja;
	
	/** The baja lab. */
	JLabel altaLab, bajaLab;
	
	
	
	/** The mi ventana principal. */
	private VentanaPrincipal miVentanaPrincipal;

	/** The alta imagen. */
	private ImageIcon altaImagen;

	/** The baja imagen. */
	private ImageIcon bajaImagen;
	
	/** The panel. */
	private JPanel panel;

	/**
	 * Instantiates a new ventana principal.
	 */
	public VentanaPrincipal() {
		
		setTitle("Gestión de apartamentos turísticos ESCAPATE");
//		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creamos una instancia de MiIcon para agregar una imagen.
		ImageIcon icono = new ImageIcon( MiIcon.class.getResource("/recursos/logo1.jpg"));
						
		//Establecemos la imagen como ícono de la ventana
		this.setIconImage(icono.getImage());
		
		ajustarTamanoVentana();
		centrarPantalla(this);
		iniciarComponentes();
		
		
		this.setJMenuBar(barraPrincipal);
		this.add(panel);
		
		setVisible(true);
		
		
	}
	
	/**
	 * Iniciar componentes.
	 */
	private void iniciarComponentes() {
		
		barraPrincipal = new JMenuBar();
		//-------------------
		
		archivo = new JMenu("Archivo");
		archivo.setMnemonic(KeyEvent.VK_A);
		
		
		salir = new JMenuItem("Salir...");
		salir.setMnemonic(KeyEvent.VK_F4);
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarAplicacion();
				
			}
			
		});
		
		//-------------------
		
		registro = new JMenu("Registro");
		registro.setMnemonic(KeyEvent.VK_R);
		
		
		altaPisos = new JMenuItem("Alta Pisos...");
		altaPisos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		altaPisos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abrirVentanaAltaPisos();
				
			}
			
		});
		
		bajaPisos = new JMenuItem("Baja Pisos...");
		bajaPisos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
		bajaPisos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarMensajeNoDesarrollado();
				
			}
			
		});
		
		
		//--------------------
		
		ayuda = new JMenu("Ayuda");
		ayuda.setMnemonic(KeyEvent.VK_H);
		
		acercaDe = new JMenuItem("Acerca de ...");
		acercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		acercaDe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarCuadro();
				
			}
		});
		
		//---------------------
		barraPrincipal.add(archivo);
		barraPrincipal.add(registro);
		barraPrincipal.add(ayuda);
		
		//---------------------
		archivo.add(salir);
		
		registro.add(altaPisos);
		registro.add(bajaPisos);
		
		ayuda.add(acercaDe);
		
		//---------------------
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		altaLab = new JLabel("Dar de alta un piso: ");
		
		alta = new JButton();
		altaImagen = new ImageIcon(MiIcon.class.getResource("/recursos/up.png"));
		alta.setIcon(altaImagen);
		alta.addActionListener(this);
		
		bajaLab = new JLabel("Dar de baja un piso: ");
		
		baja = new JButton();
		bajaImagen = new ImageIcon(MiIcon.class.getResource("/recursos/down.png"));
		baja.setIcon(bajaImagen);
		baja.addActionListener(this);
		
		panel.add(altaLab);
		panel.add(alta);
		panel.add(bajaLab);
		panel.add(baja);
		
		
		
		
	}

	/**
	 * Sets the ventana principal.
	 *
	 * @param miVentana the new ventana principal
	 */
	public void setVentanaPrincipal(VentanaPrincipal miVentana) {
		miVentanaPrincipal = miVentana;
	}
	
	
	/**
	 * Centrar pantalla.
	 *
	 * @param frame the frame
	 */
	private void centrarPantalla(JFrame frame) {
		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (pantalla.width - frame.getWidth())/2;
		int y = (pantalla.height - frame.getHeight())/2;
		
		frame.setLocation(x,y);
		
	}
	
	   
	/**
	 * Ajustar tamano ventana.
	 */
	private void ajustarTamanoVentana() {
	        
		// Obtener la resolución de la pantalla
	    
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

	    
		// Calcular el nuevo tamaño de la ventana (la mitad de la resolución)
	    
		int ancho = pantalla.width / 2;
	    
		int alto = pantalla.height / 2;
	    
		// Establecer el tamaño de la ventana
	    
		setSize(ancho, alto);
	    
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == alta) {
			VentanaDialogo miVentanaDialogo = new VentanaDialogo(miVentanaPrincipal, true);
			miVentanaDialogo.setVisible(true);
			
		}
		
		if(e.getSource() == baja) {
			mostrarMensajeNoDesarrollado();
			
		}
		
	}
	
	/**
	 * Abrir ventana alta pisos.
	 */
	private void abrirVentanaAltaPisos() {
	    // Implementar lógica para abrir la ventana de alta de pisos
	    VentanaDialogo miVentanaDialogo = new VentanaDialogo(miVentanaPrincipal, true);
	    miVentanaDialogo.setVisible(true);
	}
	
	/**
	 * Mostrar mensaje no desarrollado.
	 */
	private void mostrarMensajeNoDesarrollado() {
		 // Implementar lógica para mostrar mensaje de opción no desarrollada
	    JOptionPane.showMessageDialog(this, "Opción no desarrollada", "Advertencia", JOptionPane.WARNING_MESSAGE);
		
	}

	/**
	 * Mostrar cuadro.
	 */
	private void mostrarCuadro() {
		String mensaje = "Esta es una aplicación para gestionar el alquiler de pisos turísticos";
		
		JOptionPane.showMessageDialog(this, mensaje,"INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Cerrar aplicacion.
	 */
	private void cerrarAplicacion() {
	    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres salir?", "Confirmación", JOptionPane.YES_NO_OPTION);

	    if (confirmacion == JOptionPane.YES_OPTION) {
	        System.exit(0); // Cierra la aplicación
	    }
	}

	
	


}
