/**
 * PanelInfoUser.java
 * 22 nov 2023 19:20:50
 * @author Pedro Patricio Cárdenas Figueroa
 */
package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelInfoUser.
 */
public class PanelInfoUser extends JPanel{
	
	
	/** The campo nombre. */
	private JTextField campoNombre;
    
    /** The campo apellido. */
    private JTextField campoApellido;
    
    /** The campo tel. */
    private JFormattedTextField campoTel;
    
    /** The campo dni. */
    private JFormattedTextField campoDni;
	
	/** The nombre. */
	private String nombre;
	
	/** The apellidos. */
	private String apellidos;
	
	/** The telefono. */
	private String telefono;
	
	/** The dni. */
	private String dni;
	
	/** The text pane. */
	private JTextPane textPane;
    
    /**
     * Instantiates a new panel info user.
     */
    public PanelInfoUser() {
    	
    	setLayout(new GridLayout(4, 2));
        setBackground(new Color(181, 211, 179));
        setBorder(BorderFactory.createTitledBorder("Datos personales"));

        JLabel nombreLabel = new JLabel("Nombre: ");
        JLabel apellidosLabel = new JLabel("Apellidos: ");
        JLabel dniLabel = new JLabel("DNI: ");
        JLabel telefonoLabel = new JLabel("Telefono: ");

        campoNombre = new JTextField();
        campoNombre.addFocusListener(new FocusAdapter() {
        	@Override
            public void focusLost(FocusEvent e) {
                nombre = campoNombre.getText();
            }
        	
        });
        campoApellido = new JTextField();
        campoApellido.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                apellidos = campoApellido.getText();
            }
        });

        try {
            MaskFormatter mascara = new MaskFormatter("#########");
            campoTel = new JFormattedTextField(mascara);
            campoTel.setFocusLostBehavior(JFormattedTextField.COMMIT);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        
        campoTel.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                telefono = campoTel.getText();
            }
        });

        try {
            MaskFormatter mascara = new MaskFormatter("########U");
            campoDni = new JFormattedTextField(mascara);
            campoDni.setFocusLostBehavior(JFormattedTextField.COMMIT);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        
        campoDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                dni = campoDni.getText();
            }
        });
        
        textPane = new JTextPane();

        add(nombreLabel);
        add(campoNombre);
        add(apellidosLabel);
        add(campoApellido);
        add(telefonoLabel);
        add(campoTel);
        add(dniLabel);
        add(campoDni);
    	
    }
    
    /**
     * Obtener informacion usuario.
     *
     * @return the string
     */
    public String obtenerInformacionUsuario() {
        String nombre = campoNombre.getText();
        String apellidos = campoApellido.getText();
        String telefono = campoTel.getText();
        String dni = campoDni.getText();

        StringBuilder informacion = new StringBuilder();
        informacion.append("Nombre: ").append(nombre).append("<br>");
        informacion.append("Apellidos: ").append(apellidos).append("<br>");
        informacion.append("Teléfono: ").append(telefono).append("<br>");
        informacion.append("DNI: ").append(dni).append("<br>");
        
        System.out.println("Nombre: " + nombre);

        return informacion.toString();
    }
    
    /**
     * Reiniciar.
     */
    // Método para reiniciar el panel
    public void reiniciar() {
        campoNombre.setText("");
        campoApellido.setText("");
        campoTel.setValue(null);
        campoDni.setValue(null);
        
    }

	/**
	 * Validar datos.
	 *
	 * @return true, if successful
	 */
	public boolean validarDatos() {
		if(campoNombre.getText().isEmpty() || campoApellido.getText().isEmpty() || 
				campoTel.getText().isEmpty() || campoDni.getText().isEmpty()) {
			System.out.println("ERROR: Rellene todos los campos");
			return false;
		}else {
			return true;
		}
	}
    
}
