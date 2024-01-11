/**
 * PanelTitulo.java
 * 22 nov 2023 19:18:27
 * @author Pedro Patricio Cárdenas Figueroa
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelTitulo.
 */
public class PanelTitulo extends JPanel{
	
	/** The titulo. */
	private JLabel titulo;
	
	/**
	 * Instantiates a new panel titulo.
	 */
	public PanelTitulo() {
		setLayout(new BorderLayout());
        setBackground(new Color(161, 0, 124));

        titulo = new JLabel("ESCAPATE");
        Font font = new Font("Arial", Font.BOLD, 50);
        titulo.setFont(font);
        titulo.setForeground(new Color(245, 200, 116));

        setBorder(BorderFactory.createDashedBorder(new Color(236, 238, 202)));
        add(titulo, BorderLayout.NORTH);
	}

}
