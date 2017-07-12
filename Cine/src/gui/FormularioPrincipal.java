package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import extras.DesktopConFondo;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class FormularioPrincipal extends JFrame {
	
	public static int x, y;
	BufferedImage img;
	JToolBar toolBar = new JToolBar();	
	public JButton button;
	public JButton btn1, btn2, btn3, btn4;
	public JLabel lblfondo;
	public static JDesktopPane desktop = new DesktopConFondo("/imagen/FondoCine.jpg");
	
	public FormularioPrincipal(String cad, int x, int y) {
		super(cad);
		init();
		cerrar();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void init(){
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				FormularioPrincipal.class.getResource("/imagen/FondoCine.jpg")));
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension tamaño = tk.getScreenSize();
		x = (int) (tamaño.getWidth() / 2);
		y = (int) (tamaño.getHeight() / 2);
		
		desktop.setSize(1000, 800);
		desktop.setBackground(new Color(116, 88, 135));
		add(desktop, BorderLayout.CENTER);
		
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(0, 0, 0));
		toolBar.setForeground(new Color(0, 0, 0));
		toolBar.setRollover(true);
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setPreferredSize(new Dimension(90, 0));
		getContentPane().add(toolBar, BorderLayout.WEST);

		btn1 = new JButton("Boton1");
		btn1 = makeNavigationButton("clientes-70", "p1", "");
		btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	actualizarCliente(evt);
            }
        });
		btn1.setToolTipText("ACTUALIZAR CLIENTE");
		toolBar.add(btn1);
		
		btn2 = new JButton();
		btn2 = makeNavigationButton("peliculas-70", "p2", "");
		btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	consultarPeliculas(evt);
            }
        });
		btn2.setToolTipText("Consultar Peliculas");
		toolBar.add(btn2);
		
		btn3 = new JButton();
		btn3 = makeNavigationButton("reservas-70", "p3", "");
		btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	confirmarReserva(evt);
            }
        });
		btn3.setToolTipText("Confirmar Reserva");
		toolBar.add(btn3);

		btn4 = new JButton();
		btn4 = makeNavigationButton("carteleras-70", "p4", "");
		btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	registrarCartelera(evt);
            }
        });
		btn4.setToolTipText("Registrar Cartelera");
		toolBar.add(btn4);
		
		
	}
	
	protected JButton makeNavigationButton(String imageName,
			String actionCommand, String altText) {
		String imgLocation = "/imagen/" + imageName + ".png";
		URL imageURL = FormularioPrincipal.class.getResource(imgLocation);
		button = new JButton();
		button.setMargin(new Insets(5, 35, 5, 55));
		button.setSize(128, 128);
		button.setOpaque(false);
		button.setActionCommand(actionCommand);
		button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            }
        });
		button.setFocusable(false);
		
		if (imageURL != null) {
			button.setIcon(new ImageIcon(imageURL, altText));
		} else {
			button.setText(altText);
			System.err.println("Resource not found: " + imgLocation);
		}
		return button;
	}
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			FormularioPrincipal frame = new FormularioPrincipal("CineMark ", 1600,
					800);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);
			x = frame.getWidth();
			y = frame.getHeight();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    void actualizarCliente(ActionEvent evt) {
        try {
            FrmActualizarCliente frame = new FrmActualizarCliente(this, true);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("¡Parece que se ha producido un inconveniente!");
        }
    }
    
    void consultarPeliculas(ActionEvent evt){
    	try {
            FrmConsultarPelicula frame = new FrmConsultarPelicula(this, true);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("¡Parece que se ha producido un inconveniente!");
        }
    }
    
    void confirmarReserva(ActionEvent evt) {
        try {
            FrmListadoReserva frame = new FrmListadoReserva(this, true);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
        } catch (Exception e) {
            System.out.println("¡Parece que se ha producido un inconveniente!");
        }
    }

    void registrarCartelera(ActionEvent evt) {
        try {
            FrmRegistrarCartelera frame = new FrmRegistrarCartelera(this, true);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
        } catch (Exception e) {
            System.out.println("¡Parece que se ha producido un inconveniente!");
        }
    }
    
    public void cerrar() {
    	try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt){
					salir();
				}
			});
			this.setVisible(true);
		} catch (Exception e) {
			
		}
    }
	
    public void salir(){
    	int valor = JOptionPane.showConfirmDialog(this, "Esta seguro de salir", "Advertencia", JOptionPane.YES_NO_OPTION);
    	if(valor == JOptionPane.YES_OPTION){
    		JOptionPane.showMessageDialog(null, "Gracias por su visita");
    		System.exit(0);
    	
    	}
    }
    
}