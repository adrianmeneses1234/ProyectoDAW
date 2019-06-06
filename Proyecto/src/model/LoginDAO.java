package model;

import java.sql.SQLException;

import dto.LoginDTO;
/**
 * Clase interfaz de la clase LoginDAO
 * que incluye los metodos usados en la clase jdbcLoginDAO 
 * @author Adrian y Samuel
 * @version 6/06/19
 *
 */
public interface LoginDAO {
	/**
	 * Metodo de tipo boolean que recibe un objeto de tipo loginDTO y devuelve true or false
	 * dependiendo si cumple las condiciones (tiene que coincidir en la tabla de usuarios)
	 * @param l tipo LoginDTO
	 * @return let_in tipo boolean 
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
	public boolean Login (LoginDTO l) throws SQLException;
	/**
	 * Metodo de tipo boolean que recibe un objeto de tipo loginDTO y devuelve true or false
	 * dependiendo si cumple las condiciones (tiene que coincidir en la tabla de adminitradores)
	 * @param l tipo LoginDTO
	 * @return let_in tipo boolean 
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
	public boolean LoginAdmin (LoginDTO l) throws SQLException;
	/**
	 * Metodo de tipo boolean que recibe un objeto de tipo loginDTO y devuelve true or false
	 * dependiendo si cumple las condiciones (tiene que coincidir en la tabla de profesores)
	 * @param l tipo LoginDTO
	 * @return let_in tipo boolean 
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
	public boolean LoginProfesor (LoginDTO l) throws SQLException;
	/**
	 * Metodo Anyadir que recibe un LoginDTO l y lo añade a la base
	 * @param l tipo loginDTO
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
	public void Anyadir(LoginDTO l) throws SQLException;
	/**
	 * Metodo Eliminar que recibe un LoginDTO l lo busca en la base y lo elimina 
	 * @param l tipo loginDTO
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
	public void Eliminar(LoginDTO l) throws SQLException;
	/**
	 * Metodo Modificar que recibe un LoginDTO l y lo modifica si lo encuentra en la base 
	 * @param l tipo loginDTO
	 * @throws SQLException lanza la excepcion sobre la base de datos en MySQL
	 */
	public void Modificar(LoginDTO l) throws SQLException;


}
