package controller;

import java.io.IOException;
import dto.HardwareDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.jdbcHardwareDAO;

public class GestionHardwareController {
	
	
	@FXML
	private TextField codigoInput;
	@FXML
	private TextField nombreInput;
	@FXML
	private TextField descripcionInput;
	@FXML
	private TextField añoInput;
	@FXML
	private TextField precioInput;
	@FXML
	private TextField unidadesInput;

	@FXML
	private Button añadir;
	@FXML
	private Button modificar;
	@FXML
	private Button eliminar;
	@FXML
	private Button atras;
	
	@FXML
	private TableView<HardwareDTO> tabla;
	@FXML
	private TableColumn<String,Integer> codigo;
	@FXML
	private TableColumn<String, String> nombre;
	@FXML
	private TableColumn<String, String> descripcion;
	@FXML
	private TableColumn<String, Integer> año;
	@FXML
	private TableColumn<String, Integer> precio;
	
	@FXML
	private TableColumn<String, Integer> unidades;
	
	
	private ObservableList<HardwareDTO> itemsTable;
	private jdbcHardwareDAO base;
		
	@FXML
	private void Añadir(ActionEvent event) {
		HardwareDTO h= new HardwareDTO(Integer.parseInt(codigoInput.getText()), nombreInput.getText(), descripcionInput.getText(), Integer.parseInt(añoInput.getText()), Integer.parseInt(precioInput.getText()), Integer.parseInt(unidadesInput.getText())); 		
		if(!codigoInput.getText().equals("") && !nombreInput.getText().equals("") && !descripcionInput.getText().equals("") && !añoInput.getText().equals("") && !precioInput.getText().equals("") && !unidades.getText().equals("")) 
		{
		base.Añadir(h);
		itemsTable.add(h);
		codigo.setCellValueFactory(new PropertyValueFactory("Codigo"));
		nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
		descripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
		año.setCellValueFactory(new PropertyValueFactory("Año"));
		precio.setCellValueFactory(new PropertyValueFactory("Precio"));
		unidades.setCellValueFactory(new PropertyValueFactory("Unidades"));


		}
		
				 
		 	}
	@FXML
private void Eliminar(ActionEvent event) {
				HardwareDTO seleccion = tabla.getSelectionModel().getSelectedItem();
				base.Eliminar(seleccion);
				tabla.getItems().remove(seleccion);

		
	}

	@FXML
private void Modificar(ActionEvent event) {
		HardwareDTO h= new HardwareDTO(Integer.parseInt(codigoInput.getText()), nombreInput.getText(), descripcionInput.getText(), Integer.parseInt(añoInput.getText()), Integer.parseInt(precioInput.getText()), Integer.parseInt(unidadesInput.getText())); 		
		base.Modificar(h);
	
	}
	@FXML
	private void Atras(ActionEvent event) throws IOException {
		Parent log =  FXMLLoader.load(getClass().getResource("/view/Selector Inventario.fxml"));
	    Scene principal = new Scene(log);
	    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    PrimaryStage.hide(); 
	    PrimaryStage.setScene(principal);
	    PrimaryStage.show();  



	}


	

}
