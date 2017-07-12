package modelo;

import java.util.Date;

public class Pelicula {
	
	private int idPelicula;
	private String nomPelicula;
	private String tipo;
	private Date fecEstreno;
	
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getNomPelicula() {
		return nomPelicula;
	}
	public void setNomPelicula(String nomPelicula) {
		this.nomPelicula = nomPelicula;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecEstreno() {
		return fecEstreno;
	}
	public void setFecEstreno(Date fecEstreno) {
		this.fecEstreno = fecEstreno;
	}
	
}
