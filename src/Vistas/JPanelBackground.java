package Vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * Clase que extiende de JPanel y permite poner una imagen como fondo.
 *
 * @author Guille Rodriguez Gonzalez ( http://www.driverlandia.com )
 * @version 1.0 | 05-2014
 *
 */
public class JPanelBackground extends JPanel {

    // Atributo que guardara la imagen de Background que le pasemos.
    private Image background;
    private URL url = getClass().getResource("/imagenes/1511.jpg");

    // Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
    public void paintComponent(Graphics g) {

        /* Obtenemos el tamaño del panel para hacer que se ajuste a este
		cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
        int width = this.getSize().width;
        int height = this.getSize().height;

        // Mandamos que pinte la imagen en el panel
        if (this.background != null) {
            g.drawImage(this.background, 0, 0, width, height, null);
        }

        super.paintComponent(g);
    }

    // Metodo donde le pasaremos la dirección de la imagen a cargar.
    public void setBackground() {

        // Construimos la imagen y se la asignamos al atributo background.
        this.setOpaque(false);
        this.background = new ImageIcon(url).getImage();
        repaint();
    }

}
