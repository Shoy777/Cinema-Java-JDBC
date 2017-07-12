package extras;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class CargarFoto extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static JFileChooser jfchCargarfoto = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CargarFoto frame = new CargarFoto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CargarFoto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
	}

}
