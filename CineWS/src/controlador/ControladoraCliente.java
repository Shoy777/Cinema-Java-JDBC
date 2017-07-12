package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import util.MiConexion;

public class ControladoraCliente {
	

	public int registrarCliente(Cliente c){
		int salida = -1;
		
		Connection con = null;
		PreparedStatement pstm  = null;
		try{
			con = new MiConexion().getConexion();
			
			String sql ="insert into cliente values(null,?,?,?,?,?)";
			pstm = con.prepareStatement(sql);	
			pstm.setString(1, c.getDni());
			pstm.setString(2, c.getNomCompleto());
			pstm.setString(3, c.getEmail());
			pstm.setString(4, c.getTelFijo());
			pstm.setString(5, c.getTelMovil());
			System.out.println("---> " + pstm);
			
			salida = pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();	
		}finally{
			try {
				if(pstm!= null)pstm.close();
				if(con!= null)con.close();
			} catch (Exception e2) {}
		}
		return salida;
	}
	
	public int modificarCliente(Cliente c){
		int salida = -1;
		
		Connection con = null;
		PreparedStatement pstm  = null;
		try{
			con = new MiConexion().getConexion();
			
			String sql ="update cliente set nomCompleto=?, email=?, telFijo=?, telMovil=? where dni=?";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, c.getNomCompleto());
			pstm.setString(2, c.getEmail());
			pstm.setString(3, c.getTelFijo());
			pstm.setString(4, c.getTelMovil());
			pstm.setString(5, c.getDni());
			System.out.println("---> " + pstm);
			
			salida = pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(pstm!= null)pstm.close();
				if(con!= null)con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	

	public Cliente buscarCliente(String dni) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Cliente c = null;
		
		try {
			con = new MiConexion().getConexion();
			String sql ="select * from cliente where dni=?";  
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, dni);
			rs = pstm.executeQuery();
			System.out.println("---> " + pstm);
			
			while(rs.next()){
				c = new Cliente();
				
				c.setDni(rs.getString("dni"));
				c.setNomCompleto(rs.getString("nomCompleto"));
				c.setEmail(rs.getString("email"));
				c.setTelFijo(rs.getString("telFijo"));
				c.setTelMovil(rs.getString("telMovil"));
				c.setIdCliente(rs.getInt("idCliente"));
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
		return c;
	}
	
	public int buscarClienteDNI(String dni) {
		
		int salida = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Cliente c = null;
		
		try {
			con = new MiConexion().getConexion();
			String sql ="select * from cliente where dni=?";  
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, dni);
			rs = pstm.executeQuery();
			System.out.println("---> " + pstm);
			
			while(rs.next()){
				c = new Cliente();
				
				c.setDni(rs.getString("dni"));
				c.setNomCompleto(rs.getString("nomCompleto"));
				c.setEmail(rs.getString("email"));
				c.setTelFijo(rs.getString("telFijo"));
				c.setTelMovil(rs.getString("telMovil"));
				c.setIdCliente(rs.getInt("idCliente"));
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
		return salida;
	}


	public List<Cliente> listadoClientes() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Cliente> lista = new ArrayList<Cliente>();
		Cliente c = null;
		
		try {
			con = new MiConexion().getConexion();
			String sql ="select * from cliente";  
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			System.out.println("---> " + pstm);
			
			while(rs.next()){
				c = new Cliente();
				
				c.setDni(rs.getString("dni"));
				c.setNomCompleto(rs.getString("nomCompleto"));
				c.setEmail(rs.getString("email"));
				c.setTelFijo(rs.getString("telFijo"));
				c.setTelMovil(rs.getString("telMovil"));
				c.setIdCliente(rs.getInt("idCliente"));
				lista.add(c);
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
	
}
