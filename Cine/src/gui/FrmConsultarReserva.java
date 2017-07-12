package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class FrmConsultarReserva extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDNI;
	
	private JButton btnConfirmar;
	
	public static String fecha;
	public static Date fechaD;
	
	public static JLabel lblPelícula, lblSalaN, lblHIncio, lblHFin, lblULocal, lblNCliente;
	public static JLabel lblIdCliente, lblIdDetalle;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultarReserva frame = new FrmConsultarReserva(null, true);
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
	public FrmConsultarReserva(Frame parent, boolean modal) {
		super(parent, modal);

		setBounds(0, 0, 530, 360);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Border border;
		Border margin = new EmptyBorder(10,10,10,10);
		
		JLabel lblTitulo = new JLabel("Reservar Entrada");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(0, 0, 520, 30);
		contentPane.add(lblTitulo);
		
		lblPelícula = new JLabel("PARA EL: "+fecha);
		lblPelícula.setBounds(10, 35, 500, 20);
		lblPelícula.setBackground(Color.DARK_GRAY);
		lblPelícula.setOpaque(true);
		lblPelícula.setForeground(Color.white);
		lblPelícula.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblPelícula.getBorder();
		lblPelícula.setBorder(new CompoundBorder(border, margin));
		lblPelícula.setFont(new java.awt.Font("Tahoma", 0, 10));
		contentPane.add(lblPelícula);
		
		JLabel lblPelículaS = new JLabel("Película Seleccionada");
		lblPelículaS.setBounds(10, 60, 150, 25);
		lblPelículaS.setBackground(Color.DARK_GRAY);
		lblPelículaS.setOpaque(true);
		lblPelículaS.setForeground(Color.white);
		lblPelículaS.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblPelículaS.getBorder();
		lblPelículaS.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblPelículaS);
		
		lblPelícula = new JLabel();
		lblPelícula.setBounds(170, 60, 340, 25);
		lblPelícula.setBackground(Color.DARK_GRAY);
		lblPelícula.setOpaque(true);
		lblPelícula.setForeground(Color.white);
		lblPelícula.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		lblPelícula.setBorder(new CompoundBorder(border, margin));
		lblPelícula.setFont(new java.awt.Font("Tahoma", 0, 9));
		contentPane.add(lblPelícula);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(10, 90, 150, 25);
		lblSala.setBackground(Color.DARK_GRAY);
		lblSala.setOpaque(true);
		lblSala.setForeground(Color.white);
		lblSala.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblSala.getBorder();
		lblSala.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblSala);
		
		lblSalaN = new JLabel("");
		lblSalaN.setBounds(170, 90, 340, 25);
		lblSalaN.setBackground(Color.white);
		lblSalaN.setOpaque(true);
		lblSalaN.setForeground(Color.black);
		lblSalaN.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblSalaN.getBorder();
		lblSalaN.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblSalaN);
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setBounds(10, 120, 150, 25);
		lblInicio.setBackground(Color.DARK_GRAY);
		lblInicio.setOpaque(true);
		lblInicio.setForeground(Color.white);
		lblInicio.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblInicio.getBorder();
		lblInicio.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblInicio);

		lblHIncio = new JLabel("");
		lblHIncio.setBounds(170, 120, 340, 25);
		lblHIncio.setBackground(Color.white);
		lblHIncio.setOpaque(true);
		lblHIncio.setForeground(Color.black);
		lblHIncio.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblHIncio.getBorder();
		lblHIncio.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblHIncio);
		
		JLabel lblFin = new JLabel("Fin");
		lblFin.setBounds(10, 150, 150, 25);
		lblFin.setBackground(Color.DARK_GRAY);
		lblFin.setOpaque(true);
		lblFin.setForeground(Color.white);
		lblFin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblFin.getBorder();
		lblFin.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblFin);
		
		lblHFin = new JLabel("");
		lblHFin.setBounds(170, 150, 340, 25);
		lblHFin.setBackground(Color.white);
		lblHFin.setOpaque(true);
		lblHFin.setForeground(Color.black);
		lblHFin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblHFin.getBorder();
		lblHFin.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblHFin);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(10, 180, 150, 25);
		lblLocal.setBackground(Color.DARK_GRAY);
		lblLocal.setOpaque(true);
		lblLocal.setForeground(Color.white);
		lblLocal.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblLocal.getBorder();
		lblLocal.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblLocal);

		lblULocal = new JLabel("");
		lblULocal.setBounds(170, 180, 340, 25);
		lblULocal.setBackground(Color.white);
		lblULocal.setOpaque(true);
		lblULocal.setForeground(Color.black);
		lblULocal.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblULocal.getBorder();
		lblULocal.setBorder(new CompoundBorder(border, margin));
		lblULocal.setFont(new Font("Tahoma", Font.BOLD, 8));
		contentPane.add(lblULocal);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(10, 210, 150, 25);
		lblDNI.setBackground(Color.DARK_GRAY);
		lblDNI.setOpaque(true);
		lblDNI.setForeground(Color.white);
		lblDNI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblDNI.getBorder();
		lblDNI.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblDNI);

		txtDNI = new JTextField();
		txtDNI.setBounds(170, 210, 340, 25);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		lblNCliente = new JLabel("");
		lblNCliente.setBounds(10, 240, 500, 25);
		lblNCliente.setBackground(Color.white);
		lblNCliente.setOpaque(true);
		lblNCliente.setForeground(Color.black);
		lblNCliente.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblNCliente.getBorder();
		lblNCliente.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblNCliente);
		
		btnConfirmar = new JButton("Imprimir");
		btnConfirmar.addActionListener(this);
		btnConfirmar.setBounds(10, 270, 500, 25);
		contentPane.add(btnConfirmar);

		lblIdCliente = new JLabel("");
		lblIdCliente.setBounds(10, 300, 245, 25);
		lblIdCliente.setBackground(Color.white);
		lblIdCliente.setOpaque(true);
		lblIdCliente.setVisible(true);
		contentPane.add(lblIdCliente);

		lblIdDetalle = new JLabel("");
		lblIdDetalle.setBounds(265, 300, 245, 25);
		lblIdDetalle.setBackground(Color.white);
		lblIdDetalle.setOpaque(true);
		lblIdDetalle.setVisible(true);
		contentPane.add(lblIdDetalle);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}
