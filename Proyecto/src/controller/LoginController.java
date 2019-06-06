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
/**declaracion de la clase LoginController
 * 
 * @author Adrian y Samuel
 *@version 06/06/19
 */
public class LoginController  {
	 //declaracion de los atributos privados
		/**
		 * Declaracion de los atributos privados de FXML
		 * 
		 */	
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
    /**
	    * Declaracion de los atributos privados de la clase que no corresponden con
	    * el FXML y llamar a la clase jdbcLoginDAO y SelectorMenuController
	    */
    private jdbcLoginDAO login;
    
    private SelectorMenuController smc;
    
    
    /**
     * creacion del constructor por defecto de la clase
     */
    public LoginController() {
    	this.login= new jdbcLoginDAO(); 
    	this.smc= new SelectorMenuController();
    }
    

    /**
     * El metodo handleButtonAction recoge los datos de los TextFields username_box y password_box y con ellos se forma un Objeto LoginDTO
     * el cual se comprobará si cumple las condiciones del metodo login de la clase jdbcHardwareDAO.
     * Si se cumple las condiciones se tendrá acceso al Stage app_stage que crea un Scene basado el el FXML selectorMenu.fxml,
     * además de pasar el String nombre y contraseña de sus respectivos TextFields al SelectorMenuController para crear las condiciones 
     * de entrada de usuarios.  
     * Si no aparecerá el invalid_label indicando que el usuario o la contraseña es incorrecta.
     * @param event tipo ActionEvent
     * @throws IOException
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    	  	
    	
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/selectorMenu.fxml"));     
    	Parent root = (Parent)fxmlLoader.load();          
    	smc = fxmlLoader.<SelectorMenuController>getController();
    	smc.setNombre(this.username_box.getText());
        smc.setContrasenya(this.password_box.getText());
        
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
