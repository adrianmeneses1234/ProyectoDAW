package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDTO;

public class jdbcLoginDAO  {
	

	public boolean Login(LoginDTO l) {
		boolean let_in = false;
		PreparedStatement ps;
		
		try {
		    ps = conexion.getInstance().getConnection().prepareStatement("SELECT * FROM Empleado WHERE NombreE= ? AND Contraseña = ? AND Roles = 'Administrador';");
			ps.setString(1, l.getUsuario());
			ps.setString(2, l.getContraseña());
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {				
	                let_in = true;
				}
			ps.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				return let_in;
		}
				
		
		
	
	public void Añadir(LoginDTO l) {
		PreparedStatement ps = null;
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("INSERT INTO Empleado"
					+ " (IdentificadorE, NombreE, Contraseña, Roles)"
					+ " VALUES (?,?,?,?);");
			ps.setInt(1, l.getIdentificador());
			ps.setString(2, l.getUsuario());
			ps.setString(3, l.getContraseña());
			ps.setString(4, l.getRoles());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Eliminar(LoginDTO l) {
		PreparedStatement ps = null;
		try {
			ps =conexion.getInstance().getConnection().prepareStatement("DELETE FROM Empleado"
					+ "WHERE IdentificadorE=?");
			ps.setInt(1, l.getIdentificador());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Modificar(LoginDTO l) {
		PreparedStatement ps = null;
		try {
			ps = conexion.getInstance().getConnection().prepareStatement("UPDATE FROM Empleado"
					+ "SET NombreE = ?, Contraseña = ?, Roles= ?"
					+ "WHERE IdentificadorE = ?");
			
			ps.setString(1, l.getUsuario());
			ps.setString(2, l.getContraseña());
			ps.setString(3, l.getRoles());
			ps.setInt(4, l.getIdentificador());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
		
		
	


