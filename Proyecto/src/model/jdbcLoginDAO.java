package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDTO;

public class jdbcLoginDAO implements LoginDAO {
	
@Override
	public boolean Login(LoginDTO l) {
		boolean let_in = false;
		PreparedStatement ps;
		
		try {
		    ps = conexion.getInstance().getConnection().prepareStatement("SELECT * FROM Empleado WHERE Nombre= ? AND Contraseña = ? AND Rol = 'Administrador';");
			ps.setString(1, l.getNombre());
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
				
		
		
@Override
	public void Añadir(LoginDTO l) {
		PreparedStatement ps = null;
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("INSERT INTO Empleado"
					+ " (Identificador, Nombre, Contraseña, Rol)"
					+ " VALUES (?,?,?,?);");
			ps.setInt(1, l.getIdentificador());
			ps.setString(2, l.getNombre());
			ps.setString(3, l.getContraseña());
			ps.setString(4, l.getRol());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
@Override
	public void Eliminar(LoginDTO l) {
		PreparedStatement ps = null;
		try {
			ps =conexion.getInstance().getConnection().prepareStatement("DELETE FROM Empleado WHERE Identificador=?");
			ps.setInt(1, l.getIdentificador());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
@Override
	public void Modificar(LoginDTO l) {
		PreparedStatement ps = null;
		try {
			ps = conexion.getInstance().getConnection().prepareStatement("UPDATE Empleado SET Nombre=?, Contraseña=?, Rol=? WHERE Identificador =?;");
			
			ps.setString(1, l.getNombre());
			ps.setString(2, l.getContraseña());
			ps.setString(3, l.getRol());
			ps.setInt(4, l.getIdentificador());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
		
		
	


