package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *  Clase de conexion Singleton
 * @author Adrian y Samuel 
 * @version 6/06/19
 *
 */
public class conexion {
	/**
	 * Atributos de la clase conexion 
	 * creamos una variable de tipo conexion llamada cone en estatico
	 * creamos otra variable de tipo Connection llamada connection
	 */
	private static conexion cone;
	private Connection connection;
	/**
	 * Contructor por defecto, en este lo privatizamos para no poder
	 * hacer un conexion() desde otro lugar que no sea dentro de la 
	 * misma clase
	 */
	private conexion() {
		
	}
	/**
	 * Metodo getIntancia que devuelve la conexion, el if solo 
	 * se cumple la primera vez
	 * @return cone tipo conexion 
	 */
	public static conexion getInstance() {
		if(cone == null) {
			cone= new conexion();
		}
		return cone;
	}
	/**
	 * Metodo getConnection() que devuelve la conexion con la base de datos 
	 * 
	 * @return connection tipo Connection
	 */
	public Connection getConnection(){
		connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/m_ProyectoF?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC","m","1234");
 
        } catch (ClassNotFoundException e) {
 
            e.printStackTrace();
             
        } catch (SQLException e) {
             
            e.printStackTrace();
             
        }
        return connection;
    }
	
}
