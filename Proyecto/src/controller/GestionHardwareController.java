package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dto.HardwareDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class GestionHardwareController implements Initializable {
	
	
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
	private TableView<HardwareDTO> tabla;
	@FXML
	private TableColumn<String, Float> codigo;
	@FXML
	private TableColumn<String, Float> nombre;
	@FXML
	private TableColumn<String, Float> descripcion;
	@FXML
	private TableColumn<String, Float> año;
	@FXML
	private TableColumn<String, Float> precio;
	@FXML
	private TableColumn<String, Float> cantidad;
	@FXML
	private TableColumn<String, Float> unidades;
	
	
	private ObservableList<HardwareDTO> itemsTable;
	
	@FXML
	private void Añadir(ActionEvent event) {
		
	}
	@FXML
private void Eliminar(ActionEvent event) {
		
	}

	@FXML
private void Modificar(ActionEvent event) {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}
