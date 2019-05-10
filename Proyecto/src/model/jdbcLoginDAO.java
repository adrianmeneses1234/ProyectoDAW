package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDTO;

public class jdbcLoginDAO  {

private Connection connection;
	
	
	
	
	public Connection getConnection(){
		connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/m_Proyecto?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC","m","1234");
 
        } catch (ClassNotFoundException e) {
 
            e.printStackTrace();
             
        } catch (SQLException e) {
             
            e.printStackTrace();
             
        }
        return connection;
    }

	}
		
		
	


