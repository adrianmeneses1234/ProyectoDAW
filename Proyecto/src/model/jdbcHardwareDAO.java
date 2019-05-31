package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.HardwareDTO;
/**
 * Clase jdbcHardareDAO del modelo que gestiona la base de datos 
 * esta clase implementa los metodos estblecidos en la interfaz HardwareDAO
 * @author Adrian y Samuel 
 *
 */
public class jdbcHardwareDAO implements HardwareDAO{
	/**
	 * metodo añadir que recibe un hardareDTO h y mediante un prepareStatement se ejecuta un
	 * inset en la base de datos que añade el obejto
	 */
	@Override
	public void Añadir(HardwareDTO h) {
		PreparedStatement ps;
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("INSERT INTO Hardware (CodigoHW, Nombre, Descripcion, Año, Precio, Unidades)"
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
	/**
	 * metodo eliminar que recibe un Objeto HardareDTO h y ejecuta una query que borra el objeto si coincide el codigo
	 * con alguna de la base   
	 */
	@Override
	public void Eliminar(HardwareDTO h) {
		PreparedStatement ps = null;
		
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("DELETE FROM Hardware WHERE CodigoHW = ?;");
			ps.setInt(1, h.getCodigo());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * metodo modificar que recibe un objeto HardareDTO h y ejecuta una query que actualiza la base si datos si encuentra
	 * un codigo igual al del objeto que recibe el metodo 
	 */
	@Override
	public void Modificar(HardwareDTO h) {
		
		PreparedStatement ps = null;
		
		try {
			ps= conexion.getInstance().getConnection().prepareStatement("UPDATE Hardware SET Nombre =?, Descripcion=?, Año=?, Precio=?, Unidades=? WHERE CodigoHW=?;");
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
