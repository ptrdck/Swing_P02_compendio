/**
 * PanelInfoVivienda.java
 * 22 nov 2023 19:24:29
 * @author Pedro Patricio Cárdenas Figueroa
 */
package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelInfoVivienda.
 */
public class PanelInfoVivienda extends JPanel{
	

	/** The campo dir. */
	private JTextField campoDir;
	
	/** The campo prov. */
	private JComboBox<String> campoProv;
	
	/** The campo fecha A. */
	private JFormattedTextField campoFechaA;
	
	/** The campo fecha disp. */
	private JFormattedTextField campoFechaDisp;
	
	/** The campo huespedes. */
	private JSpinner campoHuespedes;
	
	/** The campo dormitorios. */
	private JSpinner campoDormitorios;
	
	/** The campo banos. */
	private JSpinner campoBanos;
	
	/** The campo camas. */
	private JSpinner campoCamas;
	
	/** The nino si. */
	private JCheckBox ninoSi;
	
	/** The nino no. */
	private JCheckBox ninoNo;
	
	/** The spinner edad nino. */
	private JSpinner spinnerEdadNino;
	
	/** The cama nino. */
	private JTextPane camaNino;
	
	/** The calendar. */
	private Calendar calendar;
	
	/** The campo tipo camas. */
	private JComboBox<String> campoTipoCamas;
	
	/** The panel imagenes. */
	private JPanel panelImagenes;
	
	/** The campo precio minimo. */
	private JFormattedTextField campoPrecioMinimo;

	/** The panel extras ninos. */
	private JPanel panelExtrasNinos;
	
	/**
	 * Instantiates a new panel info vivienda.
	 */
	public PanelInfoVivienda() {
        setLayout(new GridLayout(14, 2));
        setBackground(new Color(81, 151, 152));
        setBorder(BorderFactory.createTitledBorder("Datos Vivienda"));

        // Campo de dirección
        JLabel direccion = new JLabel("Dirección: ");
        campoDir = new JTextField();

        // ComboBox de provincias
        JLabel provincia = new JLabel("Provincia: ");
        campoProv = new JComboBox<String>();
        Provincias provincias = new Provincias();
        ArrayList<String> listaProvincias = provincias.getProvincias();
        for (String provi : listaProvincias) {
            campoProv.addItem(provi);
        }

        // Campo de fecha de alta
        JLabel fechaAlta = new JLabel("Fecha de alta: ");
        campoFechaA = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        campoFechaA.setValue(new Date());

        // Campo de fecha de disponibilidad
        JLabel fechaDisp = new JLabel("Fecha final de disponibilidad: ");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date fechaFutura = calendar.getTime();
        campoFechaDisp = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        campoFechaDisp.setValue(fechaFutura);

        // Configuración de spinners, checkbox, etc.
        //------ campos spinners
        JLabel huespedes = new JLabel("Número de Huéspedes: ");
        campoHuespedes = new JSpinner();
        SpinnerModel spinnerHue = new SpinnerNumberModel(0, 0, 8, 1);
        campoHuespedes.setModel(spinnerHue);

        JLabel dormitorios = new JLabel("Número de Dormitorios: ");
        campoDormitorios = new JSpinner();
        SpinnerModel spinnerDor = new SpinnerNumberModel(0, 0, 4, 1);
        campoDormitorios.setModel(spinnerDor);

        JLabel banos = new JLabel("Número de Baños: ");
        campoBanos = new JSpinner();
        SpinnerModel spinnerBanos = new SpinnerNumberModel(0, 0, 2, 1);
        campoBanos.setModel(spinnerBanos);

        JLabel camas = new JLabel("Número de Camas: ");
        campoCamas = new JSpinner();
        SpinnerModel spinnerCamas = new SpinnerNumberModel(0, 0, 4, 1);
        
        
        campoCamas.setModel(spinnerCamas);
        // Funcionalidad1 - Tipo de Camas según el número de camas
        campoCamas.addChangeListener(e ->{
        	int numCamas = (int) campoCamas.getValue();
        	campoTipoCamas.setEnabled(numCamas>0);
        });

        // ComboBox de tipo de camas
        JLabel tipoCamas = new JLabel("Tipo de camas: ");
        campoTipoCamas = new JComboBox<String>();
        campoTipoCamas.addItem("Simple");
        campoTipoCamas.addItem("Doble");
        campoTipoCamas.addItem("Sofá cama");

        // CheckBox para "¿Niños?"
        JLabel labelNinos = new JLabel("¿Niños?");
        panelExtrasNinos = new JPanel();
        panelExtrasNinos.setLayout(new BoxLayout(panelExtrasNinos, BoxLayout.X_AXIS));
        
        ButtonGroup grupoNinos = new ButtonGroup();
        
        
        ninoSi = new JCheckBox("Sí");
        ninoSi.addActionListener(e -> {
        	boolean seleccionado = ninoSi.isSelected();
        	
        	
        	if(seleccionado) {
        		//Si se selecciona uno se deselecciona el otro
        		ninoNo.setSelected(false);
        		panelExtrasNinos.setEnabled(seleccionado);
            	spinnerEdadNino.setEnabled(seleccionado);
            	camaNino.setEnabled(seleccionado);
        	}else {
        		ninoSi.setSelected(false);
        		panelExtrasNinos.setEnabled(false);
        		spinnerEdadNino.setEnabled(false);
        		camaNino.setEnabled(false);
        	}
        			
    
        	
        	
        	actualizarContenidoExtras();
        	
        });
        ninoNo = new JCheckBox("No");
        ninoNo.addActionListener(e-> {
        	if (ninoNo.isSelected()) {
        		ninoSi.setSelected(false);
        		panelExtrasNinos.setEnabled(false);
        		spinnerEdadNino.setEnabled(false);
        		camaNino.setEnabled(false);
        	}
        	
        	
        });
        grupoNinos.add(ninoSi);
        grupoNinos.add(ninoNo);
       
        panelExtrasNinos.add(Box.createHorizontalGlue());
        panelExtrasNinos.add(ninoSi);
        panelExtrasNinos.add(ninoNo);
        panelExtrasNinos.add(Box.createHorizontalGlue());
        panelExtrasNinos.setAlignmentX(CENTER_ALIGNMENT);
        
        JLabel labelEdadNino = new JLabel("Edad de Niños:");
        spinnerEdadNino = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        spinnerEdadNino.setEnabled(false);
        JLabel labelExtras = new JLabel("Extras:");
        camaNino = new JTextPane();
        
        // Funcionalidad3 - Contenido del Cuadro de Texto "Extras"
        camaNino.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
                int edadNino = (int) spinnerEdadNino.getValue();
                String contenidoExtras = obtenerContenidoExtras(edadNino);
                camaNino.setText(contenidoExtras);
            }
        	
        	
        });
        camaNino.setEnabled(false);
        
        // Funcionalidad4 - Cálculo del "Precio Mínimo"
        
       
        campoCamas.addChangeListener(e -> calcularPrecioMinimo());
        campoTipoCamas.addActionListener(e -> calcularPrecioMinimo());
        campoBanos.addChangeListener(e -> calcularPrecioMinimo());

        

        // Panel de imágenes
        panelImagenes = new JPanel(); 
        panelImagenes.setLayout(new BoxLayout(panelImagenes, BoxLayout.X_AXIS));
        MiIcon imagen1 = new MiIcon(120,90, "/recursos/piso1.jpg");
        MiIcon imagen2 = new MiIcon(120,90, "/recursos/piso2.jpg");
        MiIcon imagen3 = new MiIcon(120,90, "/recursos/piso3.jpg");
        panelImagenes.add(Box.createHorizontalGlue());
        panelImagenes.add(new JLabel(imagen1));
        panelImagenes.add(new JLabel(imagen2));
        panelImagenes.add(new JLabel(imagen3));
        panelImagenes.add(Box.createHorizontalGlue());
        panelImagenes.setAlignmentX(CENTER_ALIGNMENT);
        
        
        
        

        // JFormattedTextField para "Precio Mínimo"
        JLabel labelPrecioMinimo = new JLabel("Precio Mínimo: ");
        campoPrecioMinimo = new JFormattedTextField();
        campoPrecioMinimo.setValue(0);

        // Añadir al panel
        add(direccion);
        add(campoDir);
        add(provincia);
        add(campoProv);
        add(fechaAlta);
        add(campoFechaA);
        add(fechaDisp);
        add(campoFechaDisp);
        add(huespedes);
        add(campoHuespedes);
        add(dormitorios);
        add(campoDormitorios);
        add(banos);
        add(campoBanos);
        add(camas);
        add(campoCamas);
        add(tipoCamas);
        add(campoTipoCamas);
        add(labelNinos);
        
        add(panelExtrasNinos);
        add(labelEdadNino);
        add(spinnerEdadNino);
        add(labelExtras);
        add(camaNino);
        add(new JLabel("Imagenes:"));
        add(panelImagenes);
        add(labelPrecioMinimo);
        add(campoPrecioMinimo);
    }
	
	/**
	 * Calcular precio minimo.
	 */
	// Método para calcular el precio mínimo según la fórmula proporcionada
	private void calcularPrecioMinimo() {
	    int numCamas = (int) campoCamas.getValue();
	    int precio = numCamas * obtenerPrecioPorCama() + (int) campoBanos.getValue() * 25;
	    campoPrecioMinimo.setValue(precio);
	}

	/**
	 * Obtener precio por cama.
	 *
	 * @return the int
	 */
	// Método para obtener el precio por cama según el tipo seleccionado
	private int obtenerPrecioPorCama() {
	    String tipoCama = (String) campoTipoCamas.getSelectedItem();
	    switch (tipoCama) {
	        case "Doble":
	            return 20;
	        case "Sofá cama":
	            return 15;
	        case "Simple":
	        default:
	            return 15;
	    }
	}

	/**
	 * Obtener informacion vivienda.
	 *
	 * @return the string
	 */
	public String obtenerInformacionVivienda() {
        String direccion = campoDir.getText();
        String provincia = (String) campoProv.getSelectedItem();
        String fechaAlta = campoFechaA.getText();
        String fechaDisponibilidad = campoFechaDisp.getText();
        int numHuespedes = (int) campoHuespedes.getValue();
        int numDormitorios = (int) campoDormitorios.getValue();
        int numBanos = (int) campoBanos.getValue();
        int numCamas = (int) campoCamas.getValue();
        String tipoCamas = (String) campoTipoCamas.getSelectedItem();

        // Información sobre niños
        boolean hayNinos = ninoSi.isSelected();
        int edadNino = (int) spinnerEdadNino.getValue();
        String extrasNino = obtenerContenidoExtras(edadNino);

        

        StringBuilder informacion = new StringBuilder();
        informacion.append("Dirección: ").append(direccion).append("<br>");
        informacion.append("Provincia: ").append(provincia).append("<br>");
        informacion.append("Fecha de Alta: ").append(fechaAlta).append("<br>");
        informacion.append("Fecha de Disponibilidad: ").append(fechaDisponibilidad).append("<br>");
        informacion.append("Número de Huéspedes: ").append(numHuespedes).append("<br>");
        informacion.append("Número de Dormitorios: ").append(numDormitorios).append("<br>");
        informacion.append("Número de Baños: ").append(numBanos).append("<br>");
        informacion.append("Número de Camas: ").append(numCamas).append("<br>");
        informacion.append("Tipo de Camas: ").append(tipoCamas).append("<br>");

        // Información sobre niños
        informacion.append("¿Niños? ").append(hayNinos ? "Sí" : "No").append("<br>");
        if (hayNinos) {
            informacion.append("Edad de Niños: ").append(edadNino).append("<br>");
            informacion.append("Extras para Niños: ").append(extrasNino).append("<br>");
        }

      

        return informacion.toString();
    }

    /**
     * Obtener contenido extras.
     *
     * @param edadNino the edad nino
     * @return the string
     */
    // Método para obtener el contenido del cuadro de texto "Extras" según la edad del niño
    private String obtenerContenidoExtras(int edadNino) {
        if (edadNino >= 0 && edadNino <= 3) {
            return "cuna";
        } else if (edadNino >= 4 && edadNino <= 10) {
            return "cama supletoria pequeña";
        } else {
            return "";
        }
    }
	
	 /**
 	 * Actualizar contenido extras.
 	 */
 	// Funcionalidad3 - Contenido del Cuadro de Texto "Extras"
    private void actualizarContenidoExtras() {
        int edadNino = (int) spinnerEdadNino.getValue();
        String contenidoExtras = obtenerContenidoExtras(edadNino);
        camaNino.setText(contenidoExtras);
    }
    
 /**
  * Reiniciar.
  */
 // Método para reiniciar el panel
    public void reiniciar() {
        campoDir.setText("");
        campoProv.setSelectedIndex(0);
        campoFechaA.setValue(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        Date fechaFutura = calendar.getTime();
        campoFechaDisp.setValue(fechaFutura);
        campoHuespedes.setValue(0);
        campoDormitorios.setValue(0);
        campoBanos.setValue(0);
        campoCamas.setValue(0);
        campoTipoCamas.setSelectedIndex(0);
        ninoSi.setSelected(false);
        ninoNo.setSelected(false);
        spinnerEdadNino.setValue(0);
        camaNino.setText("");
    }

    /**
     * Validar datos.
     *
     * @return true si los datos son válidos, false en caso contrario
     */
    public boolean validarDatos() {
        boolean datosValidos = true;

        // Método para cambiar el borde y color de fondo de un componente
        // en caso de que no esté completo
        // Puedes ajustar el color a tu preferencia
        // En este ejemplo, se usará Color.RED
        setColorError(campoDir, campoDir.getText().isEmpty());
        setColorError(campoProv, campoProv.getSelectedIndex() == 0);
        setColorError(campoFechaA, campoFechaA.getValue() == null);
        setColorError(campoFechaDisp, campoFechaDisp.getValue() == null);
        setColorError(campoHuespedes, (int) campoHuespedes.getValue() == 0);
        setColorError(campoDormitorios, (int) campoDormitorios.getValue() == 0);
        setColorError(campoBanos, (int) campoBanos.getValue() == 0);
        setColorError(campoCamas, (int) campoCamas.getValue() == 0);
        setColorError(campoTipoCamas, campoTipoCamas.getSelectedIndex() == 0);

        // Aquí puedes agregar más validaciones según tus requisitos

        // Verificar si algún campo está incompleto
        if (campoDir.getText().isEmpty() || campoProv.getSelectedIndex() == 0 ||
                campoFechaA.getValue() == null || campoFechaDisp.getValue() == null ||
                (int) campoHuespedes.getValue() == 0 || (int) campoDormitorios.getValue() == 0 ||
                (int) campoBanos.getValue() == 0 || (int) campoCamas.getValue() == 0 ||
                campoTipoCamas.getSelectedIndex() == 0) {
            datosValidos = false;
        }

        return datosValidos;
    }
    
    /**
     * Método para cambiar el borde y color de fondo de un componente
     * en caso de que no esté completo.
     *
     * @param componente Componente a verificar
     * @param isError    true si hay un error, false si no lo hay
     */
    private void setColorError(JComponent componente, boolean isError) {
        if (isError) {
            componente.setBorder(BorderFactory.createLineBorder(Color.RED));
            componente.setBackground(new Color(255, 200, 200)); // Puedes ajustar el color a tu preferencia
        } else {
            componente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            componente.setBackground(Color.WHITE);
        }
    }
}
