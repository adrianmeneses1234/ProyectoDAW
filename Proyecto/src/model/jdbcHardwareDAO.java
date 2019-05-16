package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.HardwareDTO;

public class jdbcHardwareDAO {

	public void Añadir(HardwareDTO h) {
		PreparedStatement ps = null;
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("INSERT INTO Hardware (codigo, nombre, descripcion, año, precio, unidades)"
					+ " VALUES (?,?,?,?,?,? );");			
			ps.setInt(1, h.getCodigo());
			ps.setString(2, h.getNombre());
			ps.setString(3, h.getDescripcion());
			ps.setInt(4, h.getAño());
			ps.setInt(5, h.getPrecio());
			ps.setInt(6, h.getUnidades());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Eliminar(HardwareDTO h) {
		PreparedStatement ps = null;
		
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("DELETE FROM Hardware WHERE codigo = ?;");
			ps.setInt(1, h.getCodigo());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void Modificar(HardwareDTO h) {
		
		PreparedStatement ps = null;
		
		try {
			ps= conexion.getInstance().getConnection().prepareStatement("UPDATE FROM Hardware "
					+ "SET Nombre =?, Descripcion=?, Año=?, Precio=?, Unidades=?"
					+ "WHERE Codigo=?;");
			ps.setString(1, h.getNombre());
			ps.setString(2, h.getDescripcion());
			ps.setInt(3, h.getAño());
			ps.setInt(4, h.getPrecio());
			ps.setInt(5, h.getUnidades());
			ps.setInt(6, h.getCodigo());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
