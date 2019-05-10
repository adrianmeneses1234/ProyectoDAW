package controller;

import dto.HardwareDTO;
import dto.SoftwareDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionSoftwareController {
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
	private TableColumn<String, Float> codigo;
	@FXML
	private TableColumn<String, Float> nombre;
	@FXML
	private TableColumn<String, Float> descripcion;
	@FXML
	private TableColumn<String, Float> version;
	@FXML
	private TableColumn<String, Float> licencia;
	@FXML
	private TableColumn<String, Float> caducidad;
	@FXML
	private TableColumn<String, Float> precio;
	@FXML
	private TableColumn<String, Float> unidades;

	private ObservableList<SoftwareDTO> itemsTable;

	
	@FXML
	private void AñadirSoftware(ActionEvent event) {
			
		}
	@FXML
	private void EliminarSoftware(ActionEvent event) {
			
		}
	@FXML
	private void ModificarSoftware(ActionEvent event) {
			
		}


}
