package ws;

import java.util.List;

import javax.jws.WebService;

import controlador.ControladoraCliente;
import controlador.ControladoraReserva;
import modelo.Cliente;
import modelo.DetalleCartelera;
import modelo.Local;
import modelo.Reserva;

@WebService(name="WSMetodos", endpointInterface="ws.WSMetodos")
public class WSImpMetodos implements WSMetodos {

	ControladoraCliente daoC = new ControladoraCliente();
	ControladoraReserva daoR = new ControladoraReserva();
	
	//CLIENTE
	@Override
	public int registrarCliente(Cliente c) {
		return daoC.registrarCliente(c);
	}

	@Override
	public int modificarCliente(Cliente c) {
		return daoC.modificarCliente(c);
	}

	@Override
	public Cliente buscarCliente(String dni) {
		return daoC.buscarCliente(dni);
	}

	@Override
	public int buscarClienteDNI(String dni) {
		return daoC.buscarClienteDNI(dni);
	}

	@Override
	public List<Cliente> listadoClientes() {
		return daoC.listadoClientes();
	}
	
	//RESERVA
	@Override
	public List<Local> listadoLocales() {
		return daoR.listadoLocales();
	}

	@Override
	public List<DetalleCartelera> listadoCartelera(String fecha, int idLocal) {
		return daoR.listadoCartelera(fecha, idLocal);
	}

	@Override
	public void registrarReserva(Reserva r) {
		daoR.registrarReserva(r);
	}

	@Override
	public DetalleCartelera buscarLocal(int idDetalle) {
		return daoR.buscarLocal(idDetalle);
	}

	@Override
	public List<Reserva> listarReserva(String cliente, String fecha) {
		return daoR.listarReserva(cliente, fecha);
	}

	@Override
	public List<Reserva> listarReservaC(String cliente) {
		return daoR.listarReserva(cliente);
	}

	@Override
	public void confirmarReserva(Reserva r) {
		daoR.confirmarReserva(r);
	}

}
