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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.WebServiceRef;

import ws.Reserva;
import ws.WSImpMetodosService;
import ws.WSMetodos;

public class FrmConfirmarReserva extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnConfirmar;
	
	public static String fecha;
	public static Date fechaD;
	
	public static JLabel lblPel�cula, lblSalaN, lblHIncio, lblHFin, lblULocal, lblNCliente;
	public static JLabel lblIdCliente, lblIdDetalle, lblDNIC;
	
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
					FrmConfirmarReserva frame = new FrmConfirmarReserva(new javax.swing.JFrame(), true);
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
	public FrmConfirmarReserva(Frame parent, boolean modal) {
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
		
		JLabel lblTitulo = new JLabel("Confirmaci�n de Reserva");
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
		
		lblPel�cula = new JLabel("PARA EL: "+fecha);
		lblPel�cula.setBounds(10, 35, 505, 20);
		lblPel�cula.setBackground(Color.DARK_GRAY);
		lblPel�cula.setOpaque(true);
		lblPel�cula.setForeground(Color.white);
		lblPel�cula.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblPel�cula.getBorder();
		lblPel�cula.setBorder(new CompoundBorder(border, margin));
		lblPel�cula.setFont(new java.awt.Font("Tahoma", 0, 10));
		contentPane.add(lblPel�cula);
		
		JLabel lblPel�culaS = new JLabel("Pel�cula Seleccionada");
		lblPel�culaS.setBounds(10, 60, 150, 25);
		lblPel�culaS.setBackground(Color.DARK_GRAY);
		lblPel�culaS.setOpaque(true);
		lblPel�culaS.setForeground(Color.white);
		lblPel�culaS.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblPel�culaS.getBorder();
		lblPel�culaS.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblPel�culaS);
		
		lblPel�cula = new JLabel();
		lblPel�cula.setBounds(170, 60, 345, 25);
		lblPel�cula.setBackground(Color.DARK_GRAY);
		lblPel�cula.setOpaque(true);
		lblPel�cula.setForeground(Color.white);
		lblPel�cula.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		lblPel�cula.setBorder(new CompoundBorder(border, margin));
		lblPel�cula.setFont(new java.awt.Font("Tahoma", 0, 9));
		contentPane.add(lblPel�cula);
		
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
		
		JLabel lblDNI = new JLabel("Cliente");
		lblDNI.setBounds(10, 210, 150, 25);
		lblDNI.setBackground(Color.DARK_GRAY);
		lblDNI.setOpaque(true);
		lblDNI.setForeground(Color.white);
		lblDNI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblDNI.getBorder();
		lblDNI.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblDNI);

		lblDNIC = new JLabel();
		lblDNIC.setBounds(170, 210, 345, 25);
		lblDNIC.setBackground(Color.white);
		lblDNIC.setOpaque(true);
		lblDNIC.setForeground(Color.black);
		lblDNIC.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblDNIC.getBorder();
		lblDNIC.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblDNIC);
		
		lblNCliente = new JLabel("");
		lblNCliente.setBounds(10, 240, 505, 25);
		lblNCliente.setBackground(Color.white);
		lblNCliente.setOpaque(true);
		lblNCliente.setForeground(Color.black);
		lblNCliente.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblNCliente.getBorder();
		lblNCliente.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblNCliente);
		
		btnConfirmar = new JButton("Imprimir");
		btnConfirmar.setBounds(10, 270, 505, 25);
		btnConfirmar.addActionListener(this);
		contentPane.add(btnConfirmar);

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
		if(arg0.getSource() == btnConfirmar){
			confirmarReserva();
		}
	}

	WSImpMetodosService wsdao = new WSImpMetodosService();
	WSMetodos dao = wsdao.getWSMetodosPort();
	@WebServiceRef(wsdlLocation="http://localhost:8085/WSMetodos?wsdl")
	
	void confirmarReserva(){
		Reserva r = new Reserva();
		r.setIdReserva(Integer.parseInt(lblIdCliente.getText()));
		dao.confirmarReserva(r);
	}
	
}
