package ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.Cliente;
import modelo.DetalleCartelera;
import modelo.Local;
import modelo.Reserva;

@WebService(name="WSMetodos")
public interface WSMetodos {
	
	//CLIENTE
	@WebMethod
	public int registrarCliente(Cliente c);
	@WebMethod
	public int modificarCliente(Cliente c);
	@WebMethod
	public Cliente buscarCliente(String dni);
	@WebMethod
	public int buscarClienteDNI(String dni);
	@WebMethod
	public List<Cliente> listadoClientes();
	
	//RESERVA
	@WebMethod
	public List<Local> listadoLocales();
	@WebMethod
	public List<DetalleCartelera> listadoCartelera(String fecha, int idLocal);
	@WebMethod
	public void registrarReserva(Reserva r);
	@WebMethod
	public DetalleCartelera buscarLocal(int idDetalle);
	@WebMethod
	public List<Reserva> listarReserva(String cliente, String fecha);
	@WebMethod
	public List<Reserva> listarReservaC(String cliente);
	@WebMethod
	public void confirmarReserva(Reserva r);
	
}
