package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.ws.WebServiceRef;

import ws.WSImpMetodosService;
import ws.WSMetodos;
import ws.Cliente;

public class FrmRegistrarCliente extends JDialog implements ActionListener, KeyListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtNombreCompleto;
	private JTextField txtEmail, txtTelefonoFijo, txtTelefonoCelular;
	
	private JButton btnRegistrar;
	private JTable table;


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
					FrmRegistrarCliente frame = new FrmRegistrarCliente(null, true);
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
	public FrmRegistrarCliente(Frame parent, Boolean modal) {
		super(parent,modal);
		
		setBounds(0, 0, 530, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Border border;
		Border margin = new EmptyBorder(10,10,10,10);
		
		JLabel lblTitulo = new JLabel("Registro de Cliente");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(10, 10, 500, 35);
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblTitulo.getBorder();
		lblTitulo.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblTitulo);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(10, 60, 160, 25);
		lblDNI.setBackground(Color.DARK_GRAY);
		lblDNI.setOpaque(true);
		lblDNI.setForeground(Color.white);
		lblDNI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblDNI.getBorder();
		lblDNI.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(170, 60, 340, 25);
		txtDNI.addKeyListener(this);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre Completo");
		lblNombre.setBounds(10, 90, 160, 25);
		lblNombre.setBackground(Color.DARK_GRAY);
		lblNombre.setOpaque(true);
		lblNombre.setForeground(Color.white);
		lblNombre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblNombre.getBorder();
		lblNombre.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblNombre);
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setColumns(10);
		txtNombreCompleto.setBounds(170, 90, 340, 25);
		contentPane.add(txtNombreCompleto);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 120, 160, 25);
		lblEmail.setBackground(Color.DARK_GRAY);
		lblEmail.setOpaque(true);
		lblEmail.setForeground(Color.white);
		lblEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblEmail.getBorder();
		lblEmail.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(170, 120, 340, 25);
		contentPane.add(txtEmail);
		
		JLabel lblTF = new JLabel("Teléfono Fijo");
		lblTF.setBounds(10, 150, 160, 25);
		lblTF.setBackground(Color.DARK_GRAY);
		lblTF.setOpaque(true);
		lblTF.setForeground(Color.white);
		lblTF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblTF.getBorder();
		lblTF.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblTF);

		txtTelefonoFijo = new JTextField();
		txtTelefonoFijo.setColumns(10);
		txtTelefonoFijo.setBounds(170, 150, 340, 25);
		txtTelefonoFijo.addKeyListener(this);
		contentPane.add(txtTelefonoFijo);
		
		JLabel lblTC = new JLabel("Teléfono Celular");
		lblTC.setBounds(10, 180, 160, 25);
		lblTC.setBackground(Color.DARK_GRAY);
		lblTC.setOpaque(true);
		lblTC.setForeground(Color.white);
		lblTC.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblTC.getBorder();
		lblTC.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblTC);

		txtTelefonoCelular = new JTextField();
		txtTelefonoCelular.setColumns(10);
		txtTelefonoCelular.setBounds(170, 180, 340, 25);
		txtTelefonoCelular.addKeyListener(this);
		contentPane.add(txtTelefonoCelular);
		
		btnRegistrar = new JButton("Registrar Cliente");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(10, 210, 500, 25);
		contentPane.add(btnRegistrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 240, 500, 170);
		contentPane.add(scrollPane);
		
		table = new JTable(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int rowInddex, int celIndex) {
                return false;
            }
        };
		table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DNI", "Cliente","Email", "Telefono Fijo", "Telefono Celular"
			}
		));
		scrollPane.setViewportView(table);
		listar();
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(arg0);
		}
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent arg0) {
		registrarCliente();
	}
	
	WSImpMetodosService wsdao = new WSImpMetodosService();
	WSMetodos dao = wsdao.getWSMetodosPort();
	@WebServiceRef(wsdlLocation="http://localhost:8085/WSMetodos?wsdl")
	/*
	public void registrar(Cliente c){
		dao.registrarCliente(c);
	}
	*/
	public void registrarCliente(){
		String dni = txtDNI.getText();
		String email = txtEmail.getText();
		String nombre = txtNombreCompleto.getText();
		String telFijo = txtTelefonoFijo.getText();
		String telMovil = txtTelefonoCelular.getText();
		Cliente c = new Cliente();
		
		boolean emailCorrecto = false;
        emailCorrecto=email.matches("^[A-Za-z0-9-]+([_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Cliente cb = new Cliente();
		cb = dao.buscarCliente(dni);
		
		if(dni.equals("") || dni.length()<8){
			JOptionPane.showMessageDialog(null, "Ingrese un DNI correcto");
			txtDNI.requestFocus();
			
		} else if(nombre.equals("") || nombre.length()<5){
			JOptionPane.showMessageDialog(null, "Ingrese un nombre");
			txtNombreCompleto.requestFocus();
			
		} else if(email.equals("")){
			JOptionPane.showMessageDialog(null, "Ingrese email");
			txtEmail.requestFocus();
			
		} else if(emailCorrecto==false){
			JOptionPane.showMessageDialog(null, "Ingrese un email válido");
			txtEmail.requestFocus();
			
		} else if(telFijo.equals("") || telFijo.length()<7){
			JOptionPane.showMessageDialog(null, "Ingrese un Telefono Fijo");
			txtTelefonoFijo.requestFocus();
			
		} else if(telMovil.equals("") || telMovil.length()<9){
			JOptionPane.showMessageDialog(null, "Ingrese un Telefono Movil");
			txtTelefonoCelular.requestFocus();
			
		} else{
			if(cb == null){
				c.setDni(dni);
				c.setEmail(email);
				c.setNomCompleto(nombre);
				c.setTelFijo(telFijo);
				c.setTelMovil(telMovil);
				//registrar(c);
				//dao.registrarCliente(c);
				JOptionPane.showMessageDialog(null, "Cliente Registrado");
				limpiar();
				listar();
			} else{
				JOptionPane.showMessageDialog(null, "Ya existe Cliente");
			}
		}
	}
	
	private DefaultTableModel dtm;
	public void listar(){
		
		dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
			
		for (Cliente c : dao.listadoClientes()) {
			Object[] fila = {
						c.getIdCliente(),
						c.getDni(),
						c.getNomCompleto(),
						c.getEmail(),
						c.getTelFijo(),
						c.getTelMovil()};
			dtm.addRow(fila);
		}
		dtm.fireTableDataChanged();
		tamaño();
	}
	
	public void limpiar(){
		txtDNI.setText("");
		txtEmail.setText("");
		txtNombreCompleto.setText("");
		txtTelefonoCelular.setText("");
		txtTelefonoFijo.setText("");
	}
	
	public void tamaño(){
		TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(40);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(80);
        columnModel.getColumn(5).setPreferredWidth(100);
	}
	
	public void keyPressed(KeyEvent arg0) {
		
	}
	public void keyReleased(KeyEvent arg0) {
		
	}
	public void keyTyped(KeyEvent arg0) {
		
		char c = arg0.getKeyChar();
		
		if(arg0.getSource() == txtDNI){
			if(txtDNI.getText().length()>=8){
				arg0.consume();
			}
			if((c<'0' || c>'9')){
				arg0.consume();
			}
		}
		if(arg0.getSource() == txtTelefonoCelular){
			if(txtTelefonoCelular.getText().length()>=9){
				arg0.consume();
			}
			if((c<'0' || c>'9')){
				arg0.consume();
			}
		}
		if(arg0.getSource() == txtTelefonoFijo){
			if(txtTelefonoFijo.getText().length()>=7){
				arg0.consume();
			}
			if((c<'0' || c>'9')){
				arg0.consume();
			}
		}
	}
	
}
