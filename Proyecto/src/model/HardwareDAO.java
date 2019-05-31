package model;

import java.sql.SQLException;

import dto.HardwareDTO;
/**
 * Clase interfaz de la clase HardwareDAO
 * que incluye los metodos usados en la clase jdbcHardwareDAO 
 * @author Adrian y Samuel
 *
 */
public interface HardwareDAO {
	/**
	 * metodo añadir que recibe un hardaredeDTO y lo añade a la base
	 * @param h tipo HardwareDTO 
	 * @throws SQLException
	 */
	public void Añadir(HardwareDTO h) throws SQLException;
	/**
	 * metodo eliminar que recibe un hardaredeDTO y lo borra de la base
	 * @param h tipo HardwareDTO 
	 * @throws SQLException
	 */
	public void Eliminar(HardwareDTO h)throws SQLException;
	/**
	 * metodo modificar que recibe un hardwareDTO y lo modifica si lo encuentra en la base 
	 * @param h tipo HardwareDTO
	 * @throws SQLException
	 */
	public void Modificar(HardwareDTO h)throws SQLException;
	

}
