package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	
	private static conexion cone;
	private Connection connection;
	private conexion() {
		
	}
	
	public static conexion getInstance() {
		if(cone == null) {
			cone= new conexion();
		}
		return cone;
	}
	
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