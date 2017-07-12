package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.ws.WebServiceRef;

import ws.DetalleCartelera;
import ws.Local;
import ws.WSImpMetodosService;
import ws.WSMetodos;

import com.toedter.calendar.JDateChooser;

public class FrmRegistrarCartelera extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNombreCartelera;
	private JComboBox<String> cboLocal;
	private JComboBox<String> cboPelicula;
	private JComboBox<String> cboSala;
	private JButton btnRegistrarCartelera;
	private JButton btnAgregarDetalle;
	private JSpinner horaInicio;
	private JSpinner horaFin;
	private JDateChooser fechaInicio;
	private JDateChooser fechaFin;
	private JTextField txtPrecio;
	
	private JTable table;
	List<DetalleCartelera> lista = new  ArrayList<DetalleCartelera>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistrarCartelera frame = new FrmRegistrarCartelera(null, true);
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
	public FrmRegistrarCartelera(Frame parent, Boolean modal) {
		super(parent,modal);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1030, 520);
		setLocationRelativeTo(null);
		setResizable(false); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Border border;
		Border margin = new EmptyBorder(10,10,10,10);
		
		JLabel lblTitulo = new JLabel("Registrar Cartelera");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBackground(Color.DARK_GRAY);
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.white);
		lblTitulo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblTitulo.getBorder();
		lblTitulo.setBorder(new CompoundBorder(border, margin));
		lblTitulo.setBounds(0, 0, 1024, 35);
		contentPane.add(lblTitulo);
		
		JLabel lblNombreCartelera = new JLabel("Cartelera");
		lblNombreCartelera.setBounds(10, 60, 110, 25);
		lblNombreCartelera.setBackground(Color.DARK_GRAY);
		lblNombreCartelera.setOpaque(true);
		lblNombreCartelera.setForeground(Color.white);
		lblNombreCartelera.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblNombreCartelera.getBorder();
		lblNombreCartelera.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblNombreCartelera);
		
		txtNombreCartelera = new JTextField();
		txtNombreCartelera.setBounds(120, 60, 150, 25);
		contentPane.add(txtNombreCartelera);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setBounds(280, 60, 110, 25);
		lblLocal.setBackground(Color.DARK_GRAY);
		lblLocal.setOpaque(true);
		lblLocal.setForeground(Color.white);
		lblLocal.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblLocal.getBorder();
		lblLocal.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblLocal);
		
		cboLocal = new JComboBox<String>();
		cboLocal.setBounds(390, 60, 150, 25);
		cboLocal.addItem("Seleccione Local");
		for(Local e:dao.listadoLocales()){
			cboLocal.addItem(e.getUbiLocal());
		}
		contentPane.add(cboLocal);
		
		btnRegistrarCartelera = new JButton("Registrar Cartelera");
		btnRegistrarCartelera.addActionListener(this);
		btnRegistrarCartelera.setBounds(550, 60, 200, 25);
		contentPane.add(btnRegistrarCartelera);
		
		JLabel lblDetalle = new JLabel("Detalle Cartelera");
		lblDetalle.setBounds(10, 95, 210, 35);
		lblDetalle.setBackground(Color.DARK_GRAY);
		lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDetalle.setOpaque(true);
		lblDetalle.setForeground(Color.white);
		lblDetalle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblDetalle.getBorder();
		lblDetalle.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblDetalle);
		
		JLabel lblPelicula = new JLabel("Pelicula");
		lblPelicula.setBounds(10, 140, 110, 25);
		lblPelicula.setBackground(Color.DARK_GRAY);
		lblPelicula.setOpaque(true);
		lblPelicula.setForeground(Color.white);
		lblPelicula.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblPelicula.getBorder();
		lblPelicula.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblPelicula);
		
		cboPelicula = new JComboBox<String>();
		cboPelicula.setBounds(120, 140, 150, 25);
		cboPelicula.addItem("Seleccione Pelicula");
		for(Local e:dao.listadoLocales()){
			cboPelicula.addItem(e.getUbiLocal());
		}
		contentPane.add(cboPelicula);
		
		JLabel lblFechaI = new JLabel("Fecha Inicio");
		lblFechaI.setBounds(280, 140, 110, 25);
		lblFechaI.setBackground(Color.DARK_GRAY);
		lblFechaI.setOpaque(true);
		lblFechaI.setForeground(Color.white);
		lblFechaI.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblFechaI.getBorder();
		lblFechaI.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblFechaI);
		
		fechaInicio = new JDateChooser();
		fechaInicio.setBounds(390, 140, 150, 25);
		fechaInicio.setDateFormatString("yyyy-MM-dd");
		fechaInicio.getJCalendar().setMinSelectableDate(new Date());
		contentPane.add(fechaInicio);

		Date date = new Date();
		
		SpinnerDateModel smInicio = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		horaInicio = new JSpinner(smInicio);
		horaInicio.setBounds(540, 140, 100, 25);
		DateEditor deInicio = new DateEditor(horaInicio, "HH:mm:00");
		horaInicio.setEditor(deInicio);
		((DefaultEditor)horaInicio.getEditor()).getTextField().setEnabled(false);
		contentPane.add(horaInicio);
		
		JLabel lblFechaF = new JLabel("Fecha Fin");
		lblFechaF.setBounds(650, 140, 110, 25);
		lblFechaF.setBackground(Color.DARK_GRAY);
		lblFechaF.setOpaque(true);
		lblFechaF.setForeground(Color.white);
		lblFechaF.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblFechaF.getBorder();
		lblFechaF.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblFechaF);
		
		fechaFin = new JDateChooser();
		fechaFin.setBounds(760, 140, 150, 25);
		fechaFin.setDateFormatString("yyyy-MM-dd");
		fechaFin.getJCalendar().setMinSelectableDate(new Date());
		contentPane.add(fechaFin);
		
		SpinnerDateModel smFin = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		horaFin = new JSpinner(smFin);
		horaFin.setBounds(910, 140, 100, 25);
		DateEditor deFin = new DateEditor(horaFin, "HH:mm:00");
		horaFin.setEditor(deFin);
		((DefaultEditor)horaFin.getEditor()).getTextField().setEnabled(false);
		contentPane.add(horaFin);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 180, 110, 25);
		lblPrecio.setBackground(Color.DARK_GRAY);
		lblPrecio.setOpaque(true);
		lblPrecio.setForeground(Color.white);
		lblPrecio.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblPrecio.getBorder();
		lblPrecio.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(120, 180, 150, 25);
		contentPane.add(txtPrecio);
		
		JLabel lblSala = new JLabel("Sala");
		lblSala.setBounds(280, 180, 110, 25);
		lblSala.setBackground(Color.DARK_GRAY);
		lblSala.setOpaque(true);
		lblSala.setForeground(Color.white);
		lblSala.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblSala.getBorder();
		lblSala.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblSala);
		
		cboSala = new JComboBox<String>();
		cboSala.setBounds(390, 180, 150, 25);
		cboSala.addItem("Seleccione Sala");
		for(Local e:dao.listadoLocales()){
			cboSala.addItem(e.getUbiLocal());
		}
		contentPane.add(cboSala);

		btnAgregarDetalle = new JButton("Agregar Detalle");
		btnAgregarDetalle.addActionListener(this);
		btnAgregarDetalle.setBounds(550, 180, 200, 25);
		contentPane.add(btnAgregarDetalle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 1005, 260);
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
				"Película", "Fecha de Inicio", "Hora Inicio", "Fin Cartelera", "Hora Fin", "Precio", "Sala"
			}
		));
		table.addMouseListener(this);
		table.setFont(new java.awt.Font("Tahoma", 0, 10));
		
		scrollPane.setViewportView(table);
		
		tamaño();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrarCartelera) {
			do_btnRegistrarCartelera_actionPerformed(arg0);
		}
	}
	
	protected void do_btnRegistrarCartelera_actionPerformed(ActionEvent arg0) {
	}
	

	WSImpMetodosService wsdao = new WSImpMetodosService();
	WSMetodos dao = wsdao.getWSMetodosPort();
	@WebServiceRef(wsdlLocation="http://localhost:8085/WSMetodos?wsdl")
	private DefaultTableModel dtm;
	public List<DetalleCartelera> listar(String fecha, int idLocal){
		
		lista = dao.listadoCartelera(fecha, idLocal);
		dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
			
		for (DetalleCartelera dc : lista) {
			Object[] fila = {
					dc.getIdDetalle(),
					dc.getSala().getNumSala(),
					dc.getCartelera().getNomCartelera(),
					dc.getPelicula().getNomPelicula(),
					dc.getFecInicio(),
					dc.getHoraInicio(),
					dc.getHoraFin(),
					dc.getFecFin(),("RESERVAR")
			};
			dtm.addRow(fila);
		}
		dtm.fireTableDataChanged();
		return lista;
	}
	
	public void tamaño(){
		TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(300);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String sala = null,pelicula=null,horaInicio=null,horaFin=null,local=null;
		if(arg0.getClickCount()==2){
			int opcion  = JOptionPane.showConfirmDialog(null, "¿Esta seguro de realizar la reserva?","¡Reservar!", JOptionPane.YES_NO_OPTION);
			int fila = table.getSelectedRow();
			int idDetalle = 0;
			if(opcion==0){
				
				for(int i = 0; i<=fila; i++){

					idDetalle = (int) table.getValueAt(i, 0);
					sala = (String) table.getValueAt(i, 1);
					pelicula = (String) table.getValueAt(i, 3);
					table.getValueAt(i, 3);
					horaInicio = String.valueOf(table.getValueAt(i, 5));
					horaFin = String.valueOf(table.getValueAt(i, 6));
					table.getValueAt(i, 6);
					table.getValueAt(i, 7);
				}
				DetalleCartelera dc;
				dc = dao.buscarLocal(idDetalle);
				local = dc.getLocal().getDirLocal() + " - " + dc.getLocal().getNomLocal() + " - " +dc.getLocal().getUbiLocal();

				FrmReservarEntrada frame = new FrmReservarEntrada(null, true);
				
				FrmReservarEntrada.lblPelícula.setText(pelicula);
				FrmReservarEntrada.lblSalaN.setText(sala);
				FrmReservarEntrada.lblHIncio.setText(horaInicio);
				FrmReservarEntrada.lblHFin.setText(horaFin);
				FrmReservarEntrada.lblULocal.setText(local);
				FrmReservarEntrada.lblIdDetalle.setText(String.valueOf(idDetalle));
				
				frame.setVisible(true);
				
			}else if(opcion==1){
				JOptionPane.showMessageDialog(null, "¡No estes jugando!");
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
