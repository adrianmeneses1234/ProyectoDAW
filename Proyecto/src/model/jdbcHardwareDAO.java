package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.HardwareDTO;
/**
 * Clase jdbcHardareDAO del modelo que gestiona la base de datos 
 * esta clase implementa los metodos establecidos en la interfaz HardwareDAO
 * @author Adrian y Samuel.
 * @version 06/06/19 
 *
 */
public class jdbcHardwareDAO implements HardwareDAO{
	/**
	 * metodo Anyadir que recibe un HardwareDTO h y mediante un prepareStatement se ejecuta un
	 * inset en la base de datos que añade el objeto.
	 * @param h tipo HardwareDTO 
	 */
	@Override
	public void Anyadir(HardwareDTO h) {
		PreparedStatement ps;
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("INSERT INTO Hardware (CodigoHW, Nombre, Descripcion, Anyo, Precio, Unidades)"
					+ " VALUES (?,?,?,?,?,? );");			
			ps.setInt(1, h.getCodigo());
			ps.setString(2, h.getNombre());
			ps.setString(3, h.getDescripcion());
			ps.setInt(4, h.getAnyo());
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
	 * metodo Eliminar que recibe un Objeto HardareDTO h y ejecuta una query que borra el objeto si coincide el codigo
	 * con alguna de la base.
	 * @param h tipo HardwareDTO    
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
	 * metodo Modificar que recibe un objeto HardareDTO h y ejecuta una query que actualiza la base si datos si encuentra
	 * un codigo igual al del objeto que recibe el metodo .
	 * @param h tipo HardwareDTO. 
	 */
	@Override
	public void Modificar(HardwareDTO h) {
		
		PreparedStatement ps = null;
		
		try {
			ps= conexion.getInstance().getConnection().prepareStatement("UPDATE Hardware SET Nombre =?, Descripcion=?, Anyo=?, Precio=?, Unidades=? WHERE CodigoHW=?;");
			ps.setString(1, h.getNombre());
			ps.setString(2, h.getDescripcion());
			ps.setInt(3, h.getAnyo());
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
