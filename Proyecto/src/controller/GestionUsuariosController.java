package controller;

import dto.HardwareDTO;
import dto.LoginDTO;
import dto.SoftwareDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionUsuariosController {
	
	@FXML
	private TextField identificadorInput;
	@FXML
	private TextField nombreInput;
	@FXML
	private TextField contraseñaInput;
	@FXML
	private TextField rolInput;
	
	@FXML
	private Button añadir;
	@FXML
	private Button modificar;
	@FXML
	private Button eliminar;
	
	@FXML
	private TableView<LoginDTO> tabla;

	@FXML
	private TableColumn<String, Float> identificador;
	@FXML
	private TableColumn<String, Float> nombre;
	@FXML
	private TableColumn<String, Float> contraseña;
	@FXML
	private TableColumn<String, Float> rol;

	private ObservableList<LoginDTO> itemsTable;

	@FXML
	private void Añadir(ActionEvent event) {
		
	}
	@FXML
    private void Eliminar(ActionEvent event) {
		
	}

	@FXML
    private void Modificar(ActionEvent event) {
		
	}



}
