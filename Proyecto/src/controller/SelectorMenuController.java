package controller;

import java.awt.MenuItem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;

public class SelectorMenuController implements Initializable {

@FXML	
private SplitMenuButton menu;
@FXML
private MenuItem login;
@FXML
private MenuItem inventario;
@FXML
private MenuItem usuario;
 
	
@FXML
private void Volver(ActionEvent event) throws IOException {
	Parent log =  FXMLLoader.load(getClass().getResource("/view/inicio.fxml"));
    Scene principal = new Scene(log);
    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    PrimaryStage.hide(); 
    PrimaryStage.setScene(principal);
    PrimaryStage.show();  


}
@FXML
private void IrInventario(ActionEvent event) throws IOException {
	Parent log =  FXMLLoader.load(getClass().getResource("/view/Selector Inventario.fxml"));
    Scene principal = new Scene(log);
    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    PrimaryStage.hide(); 
    PrimaryStage.setScene(principal);
    PrimaryStage.show();  



}
	@FXML
    private void IrUsuario(ActionEvent event) throws IOException {
		Parent log =  FXMLLoader.load(getClass().getResource("/view/Gestion Usuarios.fxml"));
	    Scene principal = new Scene(log);
	    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    PrimaryStage.hide(); 
	    PrimaryStage.setScene(principal);
	    PrimaryStage.show();  


	}


	
	
	
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
