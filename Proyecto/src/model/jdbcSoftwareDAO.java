package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.SoftwareDTO;
/**
 * Clase jdbcSoftwareDAO del modelo que gestiona la base de datos 
 * esta clase implementa los metodos establecidos en la interfaz SoftwareDAO
 * @author Adrian y Samuel.
 * @version 06/06/19 
 *
 */
public class jdbcSoftwareDAO implements SoftwareDAO{
	/**
	 * Metodo AnyadirSoftware que recibe un SoftwareDTO s y mediante un prepareStatement se ejecuta un
	 * in set en la base de datos que añade el objeto.
	 * @param s tipo SoftwareDTO 
	 */
	@Override
	public void AnyadirSoftware(SoftwareDTO s) { 
		
		PreparedStatement ps=null;
		
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("INSERT INTO Software (CodigoSW,Nombre,Descripcion,Version,Licencia,Caducidad,Precio,Unidades)"
						+" VALUES (?,?,?,?,?,?,?,?);");
			ps.setInt(1, s.getCodigo());
			ps.setString(2, s.getNombre());
			ps.setString(3, s.getDescripcion());
			ps.setString(4, s.getVersion());
			ps.setString(5, s.getLicencia());
			ps.setString(6, s.getCaducidad());
			ps.setInt(7, s.getPrecio());
			ps.setInt(8, s.getUnidades());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	/**
	 * Metodo EliminarSoftware que recibe un Objeto SoftwareDTO d y ejecuta una query que borra el objeto si coincide el codigo
	 * con alguna de la base.
	 * @param d tipo SoftwareDTO    
	 */
	@Override
	public void EliminarSoftware(SoftwareDTO d) {
		PreparedStatement ps=null;
		
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("DELETE FROM Software WHERE CodigoSW= ?");
			ps.setInt(1, d.getCodigo());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Metodo modificarSoftware que recibe un objeto SoftwareDTO d y ejecuta una query que actualiza la base si datos si encuentra
	 * un codigo igual al del objeto que recibe el metodo .
	 * @param d tipo SoftwareDTO. 
	 */
	@Override
	public void modificarSoftware(SoftwareDTO d) {
		PreparedStatement ps=null;
		
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("UPDATE Software SET Nombre=?,Descripcion=?,Version=?,Licencia=?,Caducidad=?,Precio =?,Unidades=? WHERE CodigoSW=?;");
			ps.setString(1,d.getNombre());
			ps.setString(2, d.getDescripcion());
			ps.setString(3, d.getVersion());
			ps.setString(4, d.getLicencia());
			ps.setString(5, d.getCaducidad());
			ps.setInt(6, d.getPrecio());
			ps.setInt(7, d.getUnidades());
			ps.setInt(8, d.getCodigo());
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}