package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ws.Reserva;
import ws.WSImpMetodosService;
import ws.WSMetodos;

public class FrmListadoReserva extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTable table;
	private JDateChooser dtFecha;
	private JTextField txtNombreCompleto;
	private JButton btnBuscar;
	
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
					FrmListadoReserva frame = new FrmListadoReserva(null, true);
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
	public FrmListadoReserva(Frame parent, Boolean modal) {
		super(parent,modal);
		
		setBounds(0, 0, 1130, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Border border;
		Border margin = new EmptyBorder(10,10,10,10);
		
		JLabel lblTitulo = new JLabel("Reservas Realizadas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(0, 0, 1120, 35);
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblTitulo.getBorder();
		lblTitulo.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Cliente");
		lblNombre.setBounds(10, 50, 100, 25);
		lblNombre.setBackground(Color.DARK_GRAY);
		lblNombre.setOpaque(true);
		lblNombre.setForeground(Color.white);
		lblNombre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblNombre.getBorder();
		lblNombre.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblNombre);
		
		txtNombreCompleto = new JTextField();
		txtNombreCompleto.setColumns(10);
		txtNombreCompleto.setBounds(110, 50, 130, 25);
		contentPane.add(txtNombreCompleto);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(250, 50, 100, 25);
		lblFecha.setBackground(Color.DARK_GRAY);
		lblFecha.setOpaque(true);
		lblFecha.setForeground(Color.white);
		lblFecha.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblFecha.getBorder();
		lblFecha.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblFecha);
		
		dtFecha = new JDateChooser();
		dtFecha.setBounds(350, 50, 150, 25);
		dtFecha.setDateFormatString("yyyy-MM-dd");
		dtFecha.getJCalendar().setMinSelectableDate(new Date());
		contentPane.add(dtFecha);
		
		btnBuscar = new JButton("Buscar Reserva");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(510, 50, 200, 25);
		contentPane.add(btnBuscar);

		JTextFieldDateEditor editor = (JTextFieldDateEditor) dtFecha.getDateEditor();
		editor.setEditable(false);
		editor.getFormatter();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 1100, 270);
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
				"IDDetalle", "IDReserva", "Pelicula", "Local", "Sala", "Inicio", "Fin", "Cliente", "DNI Cliente", "Estado", "Fecha"
			}
		));
		table.addMouseListener(this);
		table.setFont(new java.awt.Font("Tahoma", 0, 10));
		scrollPane.setViewportView(table);

		tamaño();
	}
	
	WSImpMetodosService wsdao = new WSImpMetodosService();
	WSMetodos dao = wsdao.getWSMetodosPort();
	@WebServiceRef(wsdlLocation="http://localhost:8085/WSMetodos?wsdl")
	
	private DefaultTableModel dtm;
	public List<Reserva> listar(String cliente, String fecha){
		lista = dao.listarReserva(cliente, fecha);
		dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		for (Reserva r : lista) {
			Object[] fila = {
						r.getDetalleCartelera().getIdDetalle(),
						r.getIdReserva(),
						r.getPelicula().getNomPelicula(),
						r.getLocal().getDirLocal() +" - "+ r.getLocal().getNomLocal() + " - " + r.getLocal().getUbiLocal(),
						r.getSala().getNumSala(),
						r.getDetalleCartelera().getHoraInicio(),
						r.getDetalleCartelera().getHoraFin(),
						r.getCliente().getNomCompleto(),
						r.getCliente().getDni(),
						r.getEstado(),
						r.getFecReserva()
			};
			dtm.addRow(fila);
		}
		dtm.fireTableDataChanged();
		return lista;
	}
	
	public List<Reserva> listar(String cliente){
		lista = dao.listarReservaC(cliente);
		dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		for (Reserva r : lista) {
			Object[] fila = {
						r.getDetalleCartelera().getIdDetalle(),
						r.getIdReserva(),
						r.getPelicula().getNomPelicula(),
						r.getLocal().getDirLocal() +" - "+ r.getLocal().getNomLocal() + " - " + r.getLocal().getUbiLocal(),
						r.getSala().getNumSala(),
						r.getDetalleCartelera().getHoraInicio(),
						r.getDetalleCartelera().getHoraFin(),
						r.getCliente().getNomCompleto(),
						r.getCliente().getDni(),
						r.getEstado(),
						r.getFecReserva()
			};
			dtm.addRow(fila);
		}
		dtm.fireTableDataChanged();
		return lista;
	}
	
	public void tamaño(){
		TableColumnModel columnModel = table.getColumnModel();
		
		columnModel.getColumn(0).setMaxWidth(0);
		columnModel.getColumn(0).setMinWidth(0);
		columnModel.getColumn(1).setMaxWidth(0);
		columnModel.getColumn(1).setMinWidth(0);
		
        columnModel.getColumn(0).setPreferredWidth(0);
        columnModel.getColumn(1).setPreferredWidth(0);
        columnModel.getColumn(2).setPreferredWidth(300);
        columnModel.getColumn(3).setPreferredWidth(300);
        columnModel.getColumn(4).setPreferredWidth(40);
        columnModel.getColumn(5).setPreferredWidth(50);
        columnModel.getColumn(6).setPreferredWidth(50);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(100);
        columnModel.getColumn(9).setPreferredWidth(100);
        columnModel.getColumn(10).setPreferredWidth(70);
	}
	
	public void mouseClicked(MouseEvent arg0) {
		
		String sala = null,pelicula=null,horaInicio=null,horaFin=null,local=null,nomCli = null, dniCli= null,estado=null;
		Date fecha = null;
		
		if(arg0.getClickCount() == 2){
			int fila = table.getSelectedRow();
			int idReserva = 0;
			int idDetalle = 0;
			
			for(int i = 0; i<=fila; i++){
				
				idDetalle = (int) table.getValueAt(i, 0);
				idReserva = (int) table.getValueAt(i, 1);
				pelicula = (String) table.getValueAt(i, 2);
				local = (String) table.getValueAt(i, 3);
				sala = (String) table.getValueAt(i, 4);
				table.getValueAt(i, 3);
				horaInicio = String.valueOf(table.getValueAt(i, 5));
				horaFin = String.valueOf(table.getValueAt(i, 6));
				nomCli = (String)table.getValueAt(i, 7);
				dniCli = (String)table.getValueAt(i, 8);
				estado = (String)table.getValueAt(i, 9);
				fecha = (Date)table.getValueAt(i, 10);
				
				FrmConfirmarReserva.fecha = String.valueOf(fecha);
			}
			if(estado.equals("RESERVADO")){
				FrmConfirmarReserva frame = new FrmConfirmarReserva(null, true);
				FrmConfirmarReserva.lblIdCliente.setText(String.valueOf(idReserva));
				FrmConfirmarReserva.lblPelícula.setText(pelicula);
				FrmConfirmarReserva.lblSalaN.setText(sala);
				FrmConfirmarReserva.lblHIncio.setText(horaInicio);
				FrmConfirmarReserva.lblHFin.setText(horaFin);
				FrmConfirmarReserva.lblULocal.setText(local);
				FrmConfirmarReserva.lblNCliente.setText(nomCli);
				FrmConfirmarReserva.lblDNIC.setText(dniCli);
				FrmConfirmarReserva.lblIdDetalle.setText(String.valueOf(idDetalle));
				frame.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "LA RESERVA YA FUE CONFIRMADA");
			}
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		
	}
	public void mouseExited(MouseEvent arg0) {
		
	}
	public void mousePressed(MouseEvent arg0) {
		
	}
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnBuscar){
			reportePago();
			buscarReserva();
		}
	}
	void reportePago() {
		/*
		Connection con = null;
		try {

			con = new MiConexion().getConexion();

			JasperReport reporte = JasperCompileManager
					.compileReport("reporte/reporte.jrxml");

			JasperPrint imprime = JasperFillManager.fillReport(reporte, null,con);
			JasperViewer jviewer = new JasperViewer(imprime, false);
			jviewer.setVisible(true);
			jviewer.setSize(850, 600);
			jviewer.setTitle("REPORTES DE PAGOS");
			jviewer.setLocationRelativeTo(getParent());
			// jviewer.show();

		} catch (JRException e) {
			JOptionPane.showMessageDialog(this,
					"ERROR DE IMAGEN" + e.getMessage());
			e.printStackTrace();
		}
		*/
	}
	
	List<Reserva> lista = new  ArrayList<Reserva>();
	void buscarReserva(){
		
		String cliente = txtNombreCompleto.getText();
		Date fecha = dtFecha.getDate();
		
		if(!cliente.equals("") && fecha == null){
			buscarXCliente();
		}else if(!cliente.equals("") && fecha != null){
			buscarXClienteFecha();
		}
	}
	
	void buscarXClienteFecha(){
		String cliente = txtNombreCompleto.getText();
		Date fecha = dtFecha.getDate();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(cliente.equals("")){
				JOptionPane.showMessageDialog(null, "Ingrese un Cliente");
			}else if(dtFecha.getDate()==null){
				JOptionPane.showMessageDialog(null, "Elija una Fecha");
			}else{
				lista =	listar(cliente,sdf.format(fecha));
				
				if(lista.size()==0){
					JOptionPane.showMessageDialog(null, "El cliente no tiene reservas para la fecha seleccionada");
				}else{
					lista.size();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void buscarXCliente(){
		String cliente = txtNombreCompleto.getText();
		
		try {
			if(cliente.equals("")){
				JOptionPane.showMessageDialog(null, "Ingrese un Cliente");
			}else{
				lista =	listar(cliente);
				
				if(lista.size()==0){
					JOptionPane.showMessageDialog(null, "El cliente no tiene reservas para la fecha seleccionada");
				}else{
					lista.size();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
