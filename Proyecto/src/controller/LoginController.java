package controller;

import java.io.IOException;
import dto.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.jdbcLoginDAO;

public class LoginController  {
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane home_page;
    @FXML 
    private TextField username_box;
    @FXML 
    private PasswordField password_box;
    @FXML
    private Label invalid_label;
    @FXML
    private Button button;
    
    private jdbcLoginDAO login;
    
    private SelectorMenuController smc;
    
    
    
    public LoginController() {
    	this.login= new jdbcLoginDAO(); 
    	this.smc= new SelectorMenuController();
    }
    

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    	  	
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/selectorMenu.fxml"));     
    	Parent root = (Parent)fxmlLoader.load();          
    	smc = fxmlLoader.<SelectorMenuController>getController();
    	smc.setNombre(this.username_box.getText());
        smc.setContraseña(this.password_box.getText());
        
            Scene home_page_scene = new Scene(root);
            Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            
            

            
            LoginDTO l= new LoginDTO(this.username_box.getText(), this.password_box.getText());
            System.out.println("");
                        
            
            if (login.Login(l))
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




        
}
