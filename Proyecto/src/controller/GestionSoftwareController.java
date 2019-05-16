package controller;

import dto.SoftwareDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.jdbcSoftwareDAO;

public class GestionSoftwareController {
	
	private jdbcSoftwareDAO baseSoft;
	@FXML
	private TextField codigoInput;
	@FXML
	private TextField nombreInput;
	@FXML
	private TextField descripcionInput;
	@FXML
	private TextField versionInput;
	@FXML
	private TextField licenciaInput;
	@FXML
	private TextField caducidadInput;
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
	private TableView<SoftwareDTO> tabla;

	@FXML
	private TableColumn<String, Integer> codigo;
	@FXML
	private TableColumn<String, String> nombre;
	@FXML
	private TableColumn<String, String> descripcion;
	@FXML
	private TableColumn<String, String> version;
	@FXML
	private TableColumn<String, String> licencia;
	@FXML
	private TableColumn<String, Integer> caducidad;
	@FXML
	private TableColumn<String, Integer> precio;
	@FXML
	private TableColumn<String, Integer> unidades;
	
	private ObservableList<SoftwareDTO> itemsTable;

	
	@FXML
	private void AñadirSoftware(ActionEvent event) {
				
					SoftwareDTO d=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),licenciaInput.getText(),Integer.parseInt(caducidadInput.getText()),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
					
					
					
						if(!codigoInput.getText().equals("") && !nombreInput.getText().equals("") && !descripcionInput.getText().equals("") && !versionInput.getText().equals("") && !licenciaInput.getText().equals("") && !caducidadInput.getText().equals("") && !precioInput.getText().equals("") && !unidadesInput.getText().equals("")) 
						{
							baseSoft.AñadirSoftware(d);
							itemsTable.add(d);
							codigo.setCellValueFactory(new PropertyValueFactory("Codigo"));
							nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
							descripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
							version.setCellValueFactory(new PropertyValueFactory("Version"));
							licencia.setCellValueFactory(new PropertyValueFactory("Licencia"));
							caducidad.setCellValueFactory(new PropertyValueFactory("Caducidad"));
							precio.setCellValueFactory(new PropertyValueFactory("Precio"));
							unidades.setCellValueFactory(new PropertyValueFactory("Unidades"));
							
						}
						}
	@FXML
	private void EliminarSoftware(ActionEvent event) {
			
		
				SoftwareDTO seleccion = tabla.getSelectionModel().getSelectedItem();
				baseSoft.EliminarSoftware(seleccion);
				tabla.getItems().remove(seleccion);
				
	
		}
	@FXML
	private void ModificarSoftware(ActionEvent event) {
			//SoftwareDTO seleccion =  tabla.getSelectionModel().getSelectedItem();
			
			//codigoInput=tabla.getSelectionModel().getSelectedItem().getCodigo();
			
			SoftwareDTO AUX=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),licenciaInput.getText(),Integer.parseInt(caducidadInput.getText()),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
			baseSoft.modificarSoftware(AUX);
		
		}


}