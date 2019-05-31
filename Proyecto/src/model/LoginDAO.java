package model;

import java.sql.SQLException;

import dto.LoginDTO;
/**
 * Clase interfaz de la clase LoginDAO
 * que incluye los metodos usados en la clase jdbcLoginDAO 
 * @author Adrian y Samuel
 *
 */
public interface LoginDAO {
	/**
	 * metodo de tipo boolean que recibe un objeto de tipo loginDTO y devuelve true or false
	 * dependiendo si cumple las condiciones (tiene que coincidir en la tabla de usuarios)
	 * @param l
	 * @return let_in tipo boolean 
	 * @throws SQLException
	 */
	public boolean Login (LoginDTO l) throws SQLException;
	/**
	 * metodo de tipo boolean que recibe un objeto de tipo loginDTO y devuelve true or false
	 * dependiendo si cumple las condiciones (tiene que coincidir en la tabla de adminitradores)
	 * @param l
	 * @return let_in tipo boolean 
	 * @throws SQLException
	 */
	public boolean LoginAdmin (LoginDTO l) throws SQLException;
	/**
	 * metodo de tipo boolean que recibe un objeto de tipo loginDTO y devuelve true or false
	 * dependiendo si cumple las condiciones (tiene que coincidir en la tabla de profesores)
	 * @param l
	 * @return let_in tipo boolean 
	 * @throws SQLException
	 */
	public boolean LoginProfesor (LoginDTO l) throws SQLException;
	/**
	 * metodo añadir que recibe un LoginDTO l y lo añade a la base
	 * @param l tipo loginDTO
	 * @throws SQLException
	 */
	public void Anyadir(LoginDTO l) throws SQLException;
	/**
	 * metodo añadir que recibe un LoginDTO l lo busca en la base y lo elimina 
	 * @param l tipo loginDTO
	 * @throws SQLException
	 */
	public void Eliminar(LoginDTO l) throws SQLException;
	/**
	 * metodo modificar que recibe un LoginDTO l y lo modifica si lo encuentra en la base 
	 * @param l tipo loginDTO
	 * @throws SQLException
	 */
	public void Modificar(LoginDTO l) throws SQLException;


}
