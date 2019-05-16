package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDTO;

public class jdbcLoginDAO  {


	public boolean Login(LoginDTO l) {
		boolean let_in = false;
		PreparedStatement ps = null;
		
		try {
			ps =conexion.getInstance().getConnection().prepareStatement("SELECT * FROM Usuarios WHERE nombre= ? AND Contraseña =?");
			ps.setString(1, l.getUsuario());
			ps.setString(2, l.getContraseña());
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				
	                let_in = true;

				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return let_in;
		}
				
		
		
	
	public void Añadir() {
		conexion.getInstance().getConnection();
		
	}
	
	public void Eliminar() {
		conexion.getInstance().getConnection();
	}
	
	public void Modificar() {
		conexion.getInstance().getConnection();
	}
	
	
	}
		
		
	


