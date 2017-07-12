package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.WebServiceRef;

import ws.Cliente;
import ws.Reserva;
import ws.WSImpMetodosService;
import ws.WSMetodos;

public class FrmReservarEntrada extends JDialog implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDNI;
	public static String fecha;
	public static Date fechaD;
	
	public static JLabel lblPelícula, lblSalaN, lblHIncio, lblHFin, lblULocal, lblNCliente;
	public static JLabel lblIdCliente, lblIdDetalle;
	private JButton btnReservar, btnValidar, btnX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReservarEntrada frame = new FrmReservarEntrada(new javax.swing.JFrame(), true);
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
	public FrmReservarEntrada(Frame parent, boolean modal) {
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
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblTitulo.getBorder();
		lblTitulo.setBorder(new CompoundBorder(border, margin));
		lblTitulo.setBounds(0, 0, 524, 30);
		contentPane.add(lblTitulo);
		
		lblPelícula = new JLabel("PARA EL: "+fecha);
		lblPelícula.setBounds(10, 35, 505, 20);
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
		lblPelícula.setBounds(170, 60, 345, 25);
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
		lblSalaN.setBounds(170, 90, 345, 25);
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
		lblHIncio.setBounds(170, 120, 345, 25);
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
		lblHFin.setBounds(170, 150, 345, 25);
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
		lblULocal.setBounds(170, 180, 345, 25);
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
		txtDNI.setBounds(170, 210, 180, 25);
		contentPane.add(txtDNI);
		txtDNI.addKeyListener(this);
		txtDNI.setColumns(10);

		btnX = new JButton();
		btnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/delete.png")));
		btnX.addActionListener(this);
		btnX.setBounds(350, 210, 30, 25);
		contentPane.add(btnX);
		
		btnValidar = new JButton("Validar DNI");
		btnValidar.addActionListener(this);
		btnValidar.setBounds(390, 210, 125, 25);
		contentPane.add(btnValidar);
		
		lblNCliente = new JLabel("");
		lblNCliente.setBounds(10, 240, 505, 25);
		lblNCliente.setBackground(Color.white);
		lblNCliente.setOpaque(true);
		lblNCliente.setForeground(Color.black);
		lblNCliente.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		Border border7 = lblNCliente.getBorder();
		Border margin7 = new EmptyBorder(10,10,10,10);
		lblNCliente.setBorder(new CompoundBorder(border7, margin7));
		contentPane.add(lblNCliente);
		
		btnReservar = new JButton("Reservar Boleto");
		btnReservar.addActionListener(this);
		btnReservar.setBounds(10, 270, 505, 25);
		contentPane.add(btnReservar);
		
		lblIdCliente = new JLabel("");
		lblIdCliente.setBounds(10, 300, 245, 25);
		lblIdCliente.setBackground(Color.white);
		lblIdCliente.setOpaque(true);
		lblIdCliente.setVisible(true);
		contentPane.add(lblIdCliente);

		lblIdDetalle = new JLabel("");
		lblIdDetalle.setBounds(265, 300, 250, 25);
		lblIdDetalle.setBackground(Color.white);
		lblIdDetalle.setOpaque(true);
		lblIdDetalle.setVisible(true);
		contentPane.add(lblIdDetalle);
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReservar) {
			do_btnReservar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnValidar) {
			do_btnValidar_actionPerformed(arg0);
		}
		if(arg0.getSource() == btnX){
			editarDNI();
		}
	}
	
	WSImpMetodosService wsdao = new WSImpMetodosService();
	WSMetodos dao = wsdao.getWSMetodosPort();
	@WebServiceRef(wsdlLocation="http://localhost:8085/WSMetodos?wsdl")
	
	protected void do_btnReservar_actionPerformed(ActionEvent arg0) {
		
		if(lblPelícula.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Aun no ha seleccionado una pelicula");
		}else if(lblSalaN.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Parece que le falta seleccionar la sala");
		}else if(lblHIncio.getText().equals("")){
			JOptionPane.showMessageDialog(null, "No hay Hora de Inicio");
		}else if(lblHFin.getText().equals("")){
			JOptionPane.showMessageDialog(null, "No hay Hora Fin");
		}else if(lblULocal.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Ningun Local");
		}else if(lblIdCliente.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Cliente Ninguno");
			txtDNI.requestFocus();
		}else if(lblIdDetalle.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Ninguna Cartelera");
		}else if(fechaD==null){
			JOptionPane.showMessageDialog(null, "Parece que no ha ingresado una fecha para la pelicula");
		}else{
			registrarReserva();
			JOptionPane.showMessageDialog(null, "Se ha registrado su reserva");
			this.setVisible(false);
		}
		
	}

	protected void do_btnValidar_actionPerformed(ActionEvent arg0) {
		buscarCliente();
	}
	
	public void registrarReserva(){
		Reserva r = new Reserva();
		r.setEstado("RESERVADO");
		r.setFecReserva(fechaD);
		r.setIdCliente(Integer.parseInt(lblIdCliente.getText()));
		r.setIdDetalle(Integer.parseInt(lblIdDetalle.getText()));
		dao.registrarReserva(r);
	}
	
	public void buscarCliente(){
		Cliente c = new Cliente();
		String dni = txtDNI.getText();
		String nombre;
		int idCliente;
		
		c = dao.buscarCliente(dni);
		if(txtDNI.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Ingrese DNI de Cliente");
			txtDNI.requestFocus();
		}else if(c != null){
			JOptionPane.showMessageDialog(null, "Cargando datos del socio: " + c.getNomCompleto());
			nombre = c.getNomCompleto();
			idCliente = c.getIdCliente();
			lblNCliente.setText(nombre);
			lblIdCliente.setText(String.valueOf(idCliente));
			txtDNI.setEnabled(false);
			
		} else{
			int opcion  = JOptionPane.showConfirmDialog(null, "¿Quieres registrarte?","¡Registrar!", JOptionPane.YES_NO_OPTION);
			if(opcion == 0){
				FrmRegistrarCliente frame = new FrmRegistrarCliente(null, true);
				frame.setVisible(true);
			}else if(opcion == 1){
				JOptionPane.showMessageDialog(null, "Ingrese un DNI valido, Cliente con DNI '" + dni + "' no está registrado");
				txtDNI.setText("");
				txtDNI.requestFocus();
			}
		}
	}
	
	public void editarDNI(){
		txtDNI.requestFocus();
		txtDNI.setEnabled(true);
		txtDNI.setText("");
		lblIdCliente.setText("");
		lblNCliente.setText("");
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
		char c = arg0.getKeyChar();
		if(Character.isLetter(c) || txtDNI.getText().length()>=8) {
			getToolkit().beep(); 
			arg0.consume();
		}
	}
	
}
