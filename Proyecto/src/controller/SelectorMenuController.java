package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dto.LoginDTO;
import javafx.application.Platform;
import javafx.beans.property.StringPropertyBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.jdbcLoginDAO;
/**Declaracion de la clase SelectorMenuController
 * 
 * @author Adrian y Samuel
 *@version 06/06/19
 */
public class SelectorMenuController{
	 //declaracion de los atributos privados
		/**
		 * Declaracion de los atributos privados de FXML
		 * 
		 */	
	@FXML
	private Button atras;
	@FXML
	private Button inventario;
	@FXML
	private Button usuarios;
	@FXML
	private Label invalid_label;
	
	
	 /**
	    * Declaracion de los atributos privados de la clase que no corresponden con
	    * el FXML y llamar a la clase jdbcLoginDAO.
	    */
	
	private jdbcLoginDAO base;
		
	private String nombre;
	private String contrasenya;
	
	  /**
     * Creacion del constructor por defecto de la clase
     */
public SelectorMenuController() {
	this.base= new jdbcLoginDAO();
	this.nombre="";
	this.contrasenya="";
			
}
	
/**Creacion del metodo Atras en el cual al dar al boton se activa el evento
 * en el cual llama al FXML guardado en el package view inicio.fxml y monta una nueva ventana 
 * con el nuevo FXML cerrando la ventana anterior en el proceso.
 * @param event tipo ActionEvent
 * @throws IOException lanza la excepcion de IOController
 */		
@FXML
private void Atras(ActionEvent event) throws IOException {
	Parent home_page_parent =  FXMLLoader.load(getClass().getResource("/view/inicio.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    app_stage.hide();
    app_stage.setScene(home_page_scene);
    app_stage.show();  


}
/**Creacion del metodo IrInventario en el cual al dar al boton se activa el evento
 * en el cual llama al FXML guardado en el package view Selector_Inventario.fxml y monta una nueva ventana 
 * con el nuevo FXML cerrando la ventana anterior en el proceso.
 * @param event tipo ActionEvent
 * @throws IOException lanza la excepcion de IOController
 */
@FXML
private void IrInventario(ActionEvent event) throws IOException {
	Parent log =  FXMLLoader.load(getClass().getResource("/view/Selector_Inventario.fxml"));
    Scene principal = new Scene(log);
    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    PrimaryStage.hide(); 
    PrimaryStage.setScene(principal);
    PrimaryStage.show();  



}
/**Creacion del metodo IrUsuarios en el cual al dar al boton se activa el evento
 * en el cual recoge los String nombre y contraseña recogidos anteriormente en el LoginController y se pasa al metodo LoginAdmin
 * de la clase jdbcLoginDAO para comprobar si es un Administrador. Si lo es llama al FXML guardado en el package view 
 * Selector_Inventario.fxml y monta una nueva ventana con el nuevo FXML cerrando la ventana anterior en el proceso.
 * Si no aparecerá el invalid_label indicando que el usuario no puede entrar.
 ** @param event tipo ActionEvent
 * @throws IOException lanza la excepcion de IOController
 */
	@FXML
    private void IrUsuarios(ActionEvent event) throws IOException {
		
		LoginDTO l = new LoginDTO(this.nombre,this.contrasenya);
		if(base.LoginAdmin(l)) {
		Parent log =  FXMLLoader.load(getClass().getResource("/view/Gestion_Usuarios.fxml"));
	    Scene principal = new Scene(log);
	    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    PrimaryStage.hide(); 
	    PrimaryStage.setScene(principal);
	    PrimaryStage.show();  
		}
		else {
			invalid_label.setText("El Usuario no puede entrar"); 
		}


	}


	
		
	/**
     * Metodo setter de la clase para establecer el nombre
     * @param string, String parametro de tipo String que recibe para establecer el nombre 
     */
	public void setNombre(String string) {
		// TODO Auto-generated method stub
		this.nombre = string;
		
		
	}
	/**
     * Metodo setter de la clase para establecer la contraseña
     * @param contraseña, String parametro de tipo String que recibe para establecer la contraseña 
     */
	public void setContrasenya(String contraseña) {
		this.contrasenya=contraseña;
		
	}
	 /**
     *  Metodo getter de la clase para conocer el nombre 
     * @return nombre , atributo de tipo String de la clase
     */
	public String getNombre() {
		return nombre;
	}
	 /**
     *  Metodo getter de la clase para conocer la contraseña 
     * @return contraseña , atributo de tipo String de la clase
     */
	public String getContrasenya() {
		return contrasenya;
	}




}
