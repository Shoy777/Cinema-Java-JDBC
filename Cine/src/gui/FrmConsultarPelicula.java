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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
import com.toedter.calendar.JTextFieldDateEditor;

public class FrmConsultarPelicula extends JDialog implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JDateChooser dtFecha;
	private JComboBox<String> cboLocal;
	private JButton btnConsultar;
	
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
					FrmConsultarPelicula frame = new FrmConsultarPelicula(null, true);
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
	public FrmConsultarPelicula(Frame parent, Boolean modal) {
		super(parent,modal);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1030, 420);
		setLocationRelativeTo(null);
		setResizable(false); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Border border;
		Border margin = new EmptyBorder(10,10,10,10);
		
		JLabel lblTitulo = new JLabel("Consulta de Películas");
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
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 60, 110, 25);
		lblFecha.setBackground(Color.DARK_GRAY);
		lblFecha.setOpaque(true);
		lblFecha.setForeground(Color.white);
		lblFecha.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		border = lblFecha.getBorder();
		lblFecha.setBorder(new CompoundBorder(border, margin));
		contentPane.add(lblFecha);
		
		dtFecha = new JDateChooser();
		dtFecha.setBounds(120, 60, 150, 25);
		dtFecha.setDateFormatString("yyyy-MM-dd");
		dtFecha.getJCalendar().setMinSelectableDate(new Date());
		contentPane.add(dtFecha);
		
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dtFecha.getDateEditor();
		editor.setEditable(false);
		editor.getFormatter();
		
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
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(550, 60, 100, 25);
		contentPane.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 1005, 270);
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
				"", "Sala", "Cartelera", "Película", "Fecha de Inicio", "Hora Inicio", "Hora Fin", "Fin Cartelera", "Reservar"
			}
		));
		table.addMouseListener(this);
		table.setFont(new java.awt.Font("Tahoma", 0, 10));
		
		scrollPane.setViewportView(table);
		
		tamaño();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			do_btnConsultar_actionPerformed(arg0);
		}
	}
	
	protected void do_btnConsultar_actionPerformed(ActionEvent arg0) {
		
		int idLocal = cboLocal.getSelectedIndex();
		Date fecha = dtFecha.getDate();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
			if(dtFecha.getDate()==null){
				JOptionPane.showMessageDialog(null, "Elija una Fecha");
			}else if(cboLocal.getSelectedIndex()==0){
				JOptionPane.showMessageDialog(null, "Seleccione un Local");
			}else{
				lista =	listar(sdf.format(fecha), idLocal);
				FrmReservarEntrada.fecha = sdf2.format(fecha);
				FrmReservarEntrada.fechaD = fecha;
				
				if(lista.size()==0){
					JOptionPane.showMessageDialog(null, "No hay ninguna funcion para la fecha seleccionada");
				}else{
					lista.size();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	WSImpMetodosService wsdao = new WSImpMetodosService();
	WSMetodos dao = wsdao.getWSMetodosPort();
	@WebServiceRef(wsdlLocation="http://localhost:8085/WSMetodos?wsdl")
	/*
	public void registrar(Cliente c){
		dao.registrarCliente(c);
	}
	*/
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
		columnModel.getColumn(0).setMaxWidth(0);
		columnModel.getColumn(0).setMinWidth(0);

        columnModel.getColumn(0).setPreferredWidth(0);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(140);
        columnModel.getColumn(3).setPreferredWidth(300);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(100);
	}
	
	//public static FrmReservarEntrada frame = new FrmReservarEntrada(null, true);
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
