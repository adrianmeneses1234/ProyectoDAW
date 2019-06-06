package model;

import java.sql.SQLException;

import dto.SoftwareDTO;
/**
 * Clase interfaz de la clase SoftwareDAO
 * que incluye los metodos usados en la clase jdbcSoftwareDAO 
 * @author Adrian y Samuel
 * @version 06/06/19 
 */
public interface SoftwareDAO {
	/**
	 * Metodo AnyadirSoftware que recibe un SoftwareDTO s y lo añade a la base de datos
	 * @param s tipo SoftwareDTO 
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
		public void AnyadirSoftware(SoftwareDTO s) throws SQLException;
		/**
		 * Metodo EliminarSoftware que recibe un SoftwareDTO s y lo borra de la base de datos
		 * @param s tipo SoftwareDTO 
		 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
		 */
		public void EliminarSoftware(SoftwareDTO s)throws SQLException;
		/**
		 * Metodo modificarSoftware que recibe un SoftwareDTO s y lo modifica si lo encuentra en la base de datos
		 * @param s tipo SoftwareDTO
		 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
		 */
		public void modificarSoftware(SoftwareDTO s)throws SQLException;

	
	}
