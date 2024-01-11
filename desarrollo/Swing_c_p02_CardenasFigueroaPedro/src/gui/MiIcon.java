/**
 * MiIcon.java
 * 9 oct 2023 9:54:02
 * @author Pedro Patricio Cárdenas Figueroa
 */
package gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JOptionPane;


// TODO: Auto-generated Javadoc
/**
 * Clase que implementa la Interfaz Icon para proporcionar un icono personalizado
 * Esta clase carga una imagen y la muestra como icono en un componente gráfico.
 */
public class MiIcon implements Icon {

    /** La imagen que representa el icono. */
    private Image image;

    /** El ancho deseado del icono. */
    private int anchoDeseado;
    
    /** El alto deseado del icono. */
    private int altoDeseado;

    /**
     * Crea una nueva instancia de MiIcon con el ancho y alto deseados y la ruta de la imagen.
     *
     * @param anchoDeseado El ancho deseado del icono.
     * @param altoDeseado  El alto deseado del icono.
     * @param ruta         La ruta de la imagen a cargar como icono.
     */
    public MiIcon(int anchoDeseado, int altoDeseado, String ruta) {
        this.anchoDeseado = anchoDeseado;
        this.altoDeseado = altoDeseado;

        try {
            image = ImageIO.read(getClass().getResource(ruta));

            // Reescalamos la imagen al tamaño deseado
            image = image.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Imagen no encontrada", "ATENCIÓN!!!", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Dibuja el icono en un componente gráfico en las coordenadas (x, y).
     *
     * @param c El componente gráfico en el que se dibuja el icono.
     * @param g El objeto Graphics utilizado para el dibujo.
     * @param x La coordenada x donde se dibujará el icono.
     * @param y La coordenada y donde se dibujará el icono.
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (image != null) {
            g.drawImage(image, x, y, c);
        }
    }

    /**
     * Obtiene el ancho del icono.
     *
     * @return El ancho del icono.
     */
    @Override
    public int getIconWidth() {
        return anchoDeseado;
    }

    /**
     * Obtiene el alto del icono.
     *
     * @return El alto del icono.
     */
    @Override
    public int getIconHeight() {
        return altoDeseado;
    }
}