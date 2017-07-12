package modelo;

import java.util.Date;

public class Reserva {
	
	private int idReserva, idCliente, idDetalle;
	private String estado;
	private Date fecReserva;

	private DetalleCartelera detalleCartelera;
	private Sala sala;
	private Cliente cliente;
	private Pelicula pelicula;
	private Local local;
	
	public Reserva() {
		detalleCartelera = new DetalleCartelera();
		sala = new Sala();
		local = new Local();
		cliente = new Cliente();
		pelicula = new Pelicula();
	}
	
	public Date getFecReserva() {
		return fecReserva;
	}
	public void setFecReserva(Date fecReserva) {
		this.fecReserva = fecReserva;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public DetalleCartelera getDetalleCartelera() {
		return detalleCartelera;
	}
	public void setDetalleCartelera(DetalleCartelera detalleCartelera) {
		this.detalleCartelera = detalleCartelera;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	
}
