package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dto.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    @FXML
    private Button button;
    
    private jdbcLoginDAO login;
    
    public LoginController() {
    	this.login= new jdbcLoginDAO();    	
    }
    

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        
            Parent home_page_parent =  FXMLLoader.load(getClass().getResource("/view/selectorMenu.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            
            
            LoginDTO l= new LoginDTO(username_box.getText(), password_box.getText());
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
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
