package modelo;

import java.sql.Time;
import java.util.Date;

public class DetalleCartelera {
	
	private int idCartelera, idPelicula;
	private Date fecInicio, fecFin;
	private Time horaInicio, horaFin;
	private double precio;
	private String estado;
	private int idSala;
	private Cartelera cartelera;
	private Pelicula  pelicula;
	private Sala sala;
	private int idDetalle;
	private Local local;
	
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public DetalleCartelera() {
		cartelera = new Cartelera();
		pelicula = new Pelicula();
		sala = new Sala();
		local = new Local();
	}
	
	public int getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}
	
	public int getIdCartelera() {
		return idCartelera;
	}
	public void setIdCartelera(int idCartelera) {
		this.idCartelera = idCartelera;
	}
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public Date getFecInicio() {
		return fecInicio;
	}
	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}
	public Date getFecFin() {
		return fecFin;
	}
	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}
	public Time getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdSala() {
		return idSala;
	}
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	public Cartelera getCartelera() {
		return cartelera;
	}
	public void setCartelera(Cartelera cartelera) {
		this.cartelera = cartelera;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}
