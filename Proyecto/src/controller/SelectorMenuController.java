package controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class SelectorMenuController implements Initializable {
	@FXML
	private Button atras;
	@FXML
	private Button inventario;
	@FXML
	private Button usuarios;

	
	

		
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
	Parent log =  FXMLLoader.load(getClass().getResource("/view/Selector Inventario.fxml"));
    Scene principal = new Scene(log);
    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    PrimaryStage.hide(); 
    PrimaryStage.setScene(principal);
    PrimaryStage.show();  



}
	@FXML
    private void IrUsuarios(ActionEvent event) throws IOException {
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
