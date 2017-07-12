package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.DetalleCartelera;
import modelo.Local;
import modelo.Reserva;
import util.MiConexion;

public class ControladoraReserva {
	
	public List<Local> listadoLocales() {
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Local> lista = new ArrayList<Local>();
		Local l = null;
		
		try {
			con = new MiConexion().getConexion();
			String sql ="select * from local";  
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			System.out.println("---> " + pstm);
			
			while(rs.next()){
				l = new Local();
				
				l.setIdLocal(rs.getInt("idLocal"));
				l.setUbiLocal(rs.getString("ubiLocal"));
				lista.add(l);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	public List<DetalleCartelera> listadoCartelera(String fecha, int idLocal) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<DetalleCartelera> lista = new ArrayList<DetalleCartelera>();
		DetalleCartelera dc = null;
		
		try {
			con = new MiConexion().getConexion();
			
			String sql = 
					"SELECT dc.idDetalle, c.nomCartelera, p.nomPelicula, dc.fecInicio, dc.horaInicio, " +
					"dc.fecFin, dc.horaFin, s.numSala FROM detallecartelera  dc " +
					"inner join cartelera c on dc.idCartelera = c.idCartelera " +
					"inner join pelicula p  on dc.idPelicula = p.idPelicula " +
					"inner join sala s on dc.idSala = s.idSala " +
					"where ? between dc.fecInicio and dc.fecFin and c.idLocal = ?";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, fecha);
			pstm.setInt(2, idLocal);
			
			rs = pstm.executeQuery();
			System.out.println("---> " + pstm);
			
			while(rs.next()){
				dc = new DetalleCartelera();
				dc.setIdDetalle(rs.getInt("idDetalle"));
				dc.getCartelera().setNomCartelera(rs.getString("nomCartelera"));
				dc.getPelicula().setNomPelicula(rs.getString("nomPelicula"));
				dc.getSala().setNumSala(rs.getString("numSala"));
				dc.setFecInicio(rs.getDate("fecInicio"));
				dc.setHoraInicio(rs.getTime("horaInicio"));
				dc.setFecFin(rs.getDate("fecFin"));
				dc.setHoraFin(rs.getTime("horaFin"));
				
				lista.add(dc);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	public void registrarReserva(Reserva r){
		Connection con = null;
		PreparedStatement pstm  = null;
		try{
			con = new MiConexion().getConexion();
			
			String sql ="insert into reserva values(null,?,?,?,?)";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, r.getIdCliente());
			pstm.setInt(2, r.getIdDetalle());
			pstm.setString(3, r.getEstado());
			pstm.setDate(4, new Date (r.getFecReserva().getTime()));
			System.out.println("---> " + pstm);
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(pstm!= null)pstm.close();
				if(con!= null)con.close();
			} catch (Exception e2) {}
		}
	}
	
	public DetalleCartelera buscarLocal(int idDetalle){
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		DetalleCartelera dc = null;
		
		try {
			con = new MiConexion().getConexion();
			String sql =
					"select l.nomLocal, l.ubiLocal, l.dirLocal FROM detallecartelera dc " +
					"inner join cartelera c on dc.idCartelera = c.idCartelera " +
					"inner join local l on c.idLocal = l.idLocal " +
					"where dc.idDetalle = ?";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, idDetalle);
			rs = pstm.executeQuery();
			System.out.println("---> " + pstm);
			
			while(rs.next()){
				dc = new DetalleCartelera();
				dc.getLocal().setNomLocal(rs.getString("nomLocal"));
				dc.getLocal().setUbiLocal(rs.getString("ubiLocal"));
				dc.getLocal().setDirLocal(rs.getString("dirLocal"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dc;
	}
	
	public List<Reserva> listarReserva(String cliente, String fecha){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Reserva> lista = new ArrayList<Reserva>();
		Reserva r = null;
		
		try {
			con = new MiConexion().getConexion();
			String sql = 
					"select dc.idDetalle, r.idReserva, p.nomPelicula, l.nomLocal, l.dirLocal, l.ubiLocal, s.numSala, c.nomCompleto, c.dni, " +
					"dc.horaInicio, dc.horaFin, r.estado, r.fecReserva from reserva r " +
					"inner join detallecartelera dc on r.idDetalle = dc.idDetalle " +
					"inner join pelicula p on dc.idPelicula = p.idPelicula " +
					"inner join cliente c on  r.idCliente = c.idCliente " +
					"inner join cartelera ca on dc.idCartelera = ca.idCartelera " +
					"inner join sala s on dc.idSala = s.idSala " +
					"inner join local l on ca.idLocal = l.idLocal " +
					"where c.nomCompleto like ? and r.fecReserva = ?";
			
			pstm = con.prepareStatement(sql);

			pstm.setString(1, "%" +cliente +"%");
			pstm.setString(2, fecha);
			
			rs = pstm.executeQuery();
			System.out.println("---> " + pstm);
			
			while(rs.next()){
				r = new Reserva();
				r.getDetalleCartelera().setIdDetalle(rs.getInt("idDetalle"));
				r.setIdReserva(rs.getInt("idReserva"));
				r.getPelicula().setNomPelicula(rs.getString("nomPelicula"));
				r.getLocal().setDirLocal(rs.getString("dirLocal"));
				r.getLocal().setNomLocal(rs.getString("nomLocal"));
				r.getLocal().setUbiLocal(rs.getString("ubiLocal"));
				r.getSala().setNumSala(rs.getString("numSala"));
				r.getCliente().setNomCompleto(rs.getString("nomCompleto"));
				r.getCliente().setDni(rs.getString("dni"));
				r.getDetalleCartelera().setHoraInicio(rs.getTime("horaInicio"));
				r.getDetalleCartelera().setHoraFin(rs.getTime("horaFin"));
				r.setEstado(rs.getString("estado"));
				r.setFecReserva(rs.getDate("fecReserva"));
				
				lista.add(r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	

	public List<Reserva> listarReserva(String cliente){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Reserva> lista = new ArrayList<Reserva>();
		Reserva r = null;
		
		try {
			con = new MiConexion().getConexion();
			String sql = 
					"select dc.idDetalle, r.idReserva, p.nomPelicula, l.nomLocal, l.dirLocal, l.ubiLocal, s.numSala, c.nomCompleto, c.dni, " +
					"dc.horaInicio, dc.horaFin, r.estado, r.fecReserva from reserva r " +
					"inner join detallecartelera dc on r.idDetalle = dc.idDetalle " +
					"inner join pelicula p on dc.idPelicula = p.idPelicula " +
					"inner join cliente c on  r.idCliente = c.idCliente " +
					"inner join cartelera ca on dc.idCartelera = ca.idCartelera " +
					"inner join sala s on dc.idSala = s.idSala " +
					"inner join local l on ca.idLocal = l.idLocal " +
					"where c.nomCompleto like ?";
			
			pstm = con.prepareStatement(sql);

			pstm.setString(1, "%" +cliente +"%");
			
			rs = pstm.executeQuery();
			System.out.println("---> " + pstm);
			
			while(rs.next()){
				r = new Reserva();
				r.getDetalleCartelera().setIdDetalle(rs.getInt("idDetalle"));
				r.setIdReserva(rs.getInt("idReserva"));
				r.getPelicula().setNomPelicula(rs.getString("nomPelicula"));
				r.getLocal().setDirLocal(rs.getString("dirLocal"));
				r.getLocal().setNomLocal(rs.getString("nomLocal"));
				r.getLocal().setUbiLocal(rs.getString("ubiLocal"));
				r.getSala().setNumSala(rs.getString("numSala"));
				r.getCliente().setNomCompleto(rs.getString("nomCompleto"));
				r.getCliente().setDni(rs.getString("dni"));
				r.getDetalleCartelera().setHoraInicio(rs.getTime("horaInicio"));
				r.getDetalleCartelera().setHoraFin(rs.getTime("horaFin"));
				r.setEstado(rs.getString("estado"));
				r.setFecReserva(rs.getDate("fecReserva"));
				lista.add(r);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	public void confirmarReserva(Reserva r){
		Connection con = null;
		PreparedStatement pstm  = null;
		try{
			con = new MiConexion().getConexion();
			
			String sql ="update reserva set estado = 'CONFIRMADO' where idReserva = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, r.getIdReserva());
			System.out.println("---> " + pstm);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
