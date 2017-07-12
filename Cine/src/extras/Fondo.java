package extras;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Image imagen;

    public Fondo() {
    }
	//CONSTRUCTOR CON PARAMETRO PARA PONER LA IMAGEN QUE QUEREMOS MOSTRAR - RUTA
    public Fondo(String nombreImagen) {
    	imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
    }
    
    public void setImagen(String nombreImagen) {
            imagen = new ImageIcon(getClass().getResource(nombreImagen)).getImage();
        repaint();
    }

    public void paint(Graphics g) {
        //g.drawImage: dibujamos la imagen (guardada en  imagen) en toda el Jpanel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        //EL PANEL QUITARA SU FONDO POR DEFECTO
        setOpaque(false);
        // super.paint(g): QUE SIGA DIBUJANDO LOS DEMAS COMPONENTES
        super.paint(g);
    }
}
