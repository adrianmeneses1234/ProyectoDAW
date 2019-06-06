package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDTO;
/**
 * Clase jdbcLoginDAO del modelo que gestiona la base de datos 
 * esta clase implementa los metodos establecidos en la interfaz LoginDAO
 * @author Adrian y Samuel.
 * @version 06/06/19 
 *
 */
public class jdbcLoginDAO implements LoginDAO {
	/**
	 * El Metodo boolean Login recibe el objeto LoginDTO l y mediante un PreparedStatement se comprueba si 
	 * el nombre y la contraseña del LoginDTO l coincide con el nombre y la contraseña guardada en la base de datos.
	 * Si coincide el boolean es true, validando el usuario y si no coincide el boolean es falso, invalidando 
	 * el proceso.
	 * @param l tipo LoginDTO
	 * @return let_in tipo boolean true or false
	 *  
	 */
@Override
	public boolean Login(LoginDTO l) {
		boolean let_in = false;
		PreparedStatement ps;
		
		try {
		    ps = conexion.getInstance().getConnection().prepareStatement("SELECT * FROM Empleado WHERE Nombre= ? AND Contrasenya = ?;");
			ps.setString(1, l.getNombre());
			ps.setString(2, l.getContrasenya());
			
			
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
/**
 * El Metodo boolean LoginAdmin recibe el objeto LoginDTO l y mediante un PreparedStatement se comprueba si 
 * el nombre y la contraseña del LoginDTO l coincide con el nombre y la contraseña guardada en la base de datos,
 * ademas de contener el rol de Administrador.
 * Si coincide el boolean es true, validando el usuario y si no coincide el boolean es falso, invalidando 
 * el proceso.
 * @param l tipo LoginDTO
 * @return let_in tipo boolean true or false
 *  
 */
public boolean LoginAdmin(LoginDTO l) {
	boolean let_in = false;
	PreparedStatement ps;
	
	try {
	    ps = conexion.getInstance().getConnection().prepareStatement("SELECT * FROM Empleado WHERE Nombre=? AND Contrasenya =? AND Rol = 'Administrador';");
		ps.setString(1, l.getNombre());
		ps.setString(2, l.getContrasenya());
		
		
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
	
/**
 * El Metodo boolean LoginProfesor recibe el objeto LoginDTO l y mediante un PreparedStatement se comprueba si 
 * el nombre y la contraseña del LoginDTO l coincide con el nombre y la contraseña guardada en la base de datos,
 * ademas de contener el rol de Profesor.
 * Si coincide el boolean es true, validando el usuario y si no coincide el boolean es falso, invalidando 
 * el proceso.
 * @param l tipo LoginDTO
 * @return let_in tipo boolean true or false
 *  
 */
@Override
public boolean LoginProfesor(LoginDTO l) {
	boolean let_in = false;
	PreparedStatement ps;
	
	try {
	    ps = conexion.getInstance().getConnection().prepareStatement("SELECT * FROM Empleado WHERE Nombre=? AND Contrasenya=? AND Rol=Profesor;");
		ps.setString(1, l.getNombre());
		ps.setString(2, l.getContrasenya());
		
		
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
	



/**
 * Metodo Añadir que recibe un LoginDTO l y mediante un prepareStatement se ejecuta un
 * inset en la base de datos que añade el objeto.
 * @param l tipo LoginDTO 
 */
				
		
		
@Override
	public void Anyadir(LoginDTO l) {
		PreparedStatement ps = null;
		try {
			ps=conexion.getInstance().getConnection().prepareStatement("INSERT INTO Empleado"
					+ " (Identificador, Nombre, Contrasenya, Rol)"
					+ " VALUES (?,?,?,?);");
			ps.setInt(1, l.getIdentificador());
			ps.setString(2, l.getNombre());
			ps.setString(3, l.getContrasenya());
			ps.setString(4, l.getRol());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
/**
 * Metodo Eliminar que recibe un Objeto LoginDTO l y ejecuta una query que borra el objeto si coincide el codigo
 * con alguna de la base.
 * @param l tipo LoginDTO    
 */
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
/**
 * Metodo Modificar que recibe un objeto LoginDTO l y ejecuta una query que actualiza la base si datos si encuentra
 * un codigo igual al del objeto que recibe el metodo .
 * @param l tipo LoginDTO. 
 */
@Override
	public void Modificar(LoginDTO l) {
		PreparedStatement ps = null;
		try {
			ps = conexion.getInstance().getConnection().prepareStatement("UPDATE Empleado SET Nombre=?, Contrasenya=?, Rol=? WHERE Identificador =?;");
			
			ps.setString(1, l.getNombre());
			ps.setString(2, l.getContrasenya());
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
		
		
	


