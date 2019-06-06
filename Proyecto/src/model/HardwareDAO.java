package model;

import java.sql.SQLException;

import dto.HardwareDTO;
/**
 * Clase interfaz de la clase HardwareDAO
 * que incluye los metodos usados en la clase jdbcHardwareDAO 
 * @author Adrian y Samuel
 *@version 06/06/19 
 */
public interface HardwareDAO {
	/**
	 * Metodo Anyadir que recibe un HardwareDTO h y lo añade a la base
	 * @param h tipo HardwareDTO 
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
	public void Anyadir(HardwareDTO h) throws SQLException;
	/**
	 * Metodo Eliminar que recibe un HardwareDTO h y lo borra de la base
	 * @param h tipo HardwareDTO 
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
	public void Eliminar(HardwareDTO h)throws SQLException;
	/**
	 * Metodo Modificar que recibe un HardwareDTO h y lo modifica si lo encuentra en la base 
	 * @param h tipo HardwareDTO
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
	public void Modificar(HardwareDTO h)throws SQLException;
	

}
