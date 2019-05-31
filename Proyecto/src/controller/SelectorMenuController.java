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

public class SelectorMenuController{
	@FXML
	private Button atras;
	@FXML
	private Button inventario;
	@FXML
	private Button usuarios;
	@FXML
	private Label invalid_label;
	
	
	
	
	private jdbcLoginDAO base;
		
	private String nombre;
	private String contrasenya;

public SelectorMenuController() {
	this.base= new jdbcLoginDAO();
	this.nombre="";
	this.contrasenya="";
			
}
	
			
@FXML
private void Atras(ActionEvent event) throws IOException {
	Parent home_page_parent =  FXMLLoader.load(getClass().getResource("/view/inicio.fxml"));
    Scene home_page_scene = new Scene(home_page_parent);
    Stage app_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    app_stage.hide();
    app_stage.setScene(home_page_scene);
    app_stage.show();  


}
@FXML
private void IrInventario(ActionEvent event) throws IOException {
	Parent log =  FXMLLoader.load(getClass().getResource("/view/Selector_Inventario.fxml"));
    Scene principal = new Scene(log);
    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    PrimaryStage.hide(); 
    PrimaryStage.setScene(principal);
    PrimaryStage.show();  



}
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


	
		
	
	public void setNombre(String string) {
		// TODO Auto-generated method stub
		this.nombre = string;
		
		
	}
	public void setContrasenya(String contraseña) {
		this.contrasenya=contraseña;
		
	}
	public String getNombre() {
		return nombre;
	}
	public String getContrasenya() {
		return contrasenya;
	}




}
