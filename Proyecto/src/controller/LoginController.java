package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.jdbcLoginDAO;

public class LoginController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane home_page;
    @FXML 
    private TextField username_box;
    @FXML 
    private TextField password_box;
    @FXML
    private Label invalid_label;
    
    private jdbcLoginDAO login;
    

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
            Parent home_page_parent =  FXMLLoader.load(getClass().getResource("/view/selectorMenu.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            
            if (isValidCredentials())
            {
                app_stage.hide();
                app_stage.setScene(home_page_scene);
                app_stage.show();  
            }
            else
            {
                username_box.clear();
                password_box.clear();
                invalid_label.setText("Usuario o contraseña Incorrecta"); 
            }
    }
    
    private boolean isValidCredentials()
    {
        boolean let_in = false;
          
        try {
        	conexion = base.getConnection();
			statement = conexion.createStatement();
            conexion.setAutoCommit(false);
            
            
            statement = conexion.createStatement();
            
            rs = statement.executeQuery( "SELECT * FROM Usuarios WHERE nombre= " + "'" + username_box.getText() + "'" 
            + " AND contraseña= " + "'" + password_box.getText() + "'"
            + "AND roles= Administrador");
            
            while ( rs.next() ) {
                 if (rs.getString("Nombre") != null && rs.getString("Contraseña") != null) { 
                     String  username = rs.getString("Nombre");                    
                     String password = rs.getString("Contraseña");                    
                     let_in = true;
                 }  
            }
            rs.close();
            statement.close();
            conexion.close();
            } catch ( Exception e ) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            
        return let_in;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
