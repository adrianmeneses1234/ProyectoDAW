package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import javafx.scene.control.cell.PropertyValueFactory;
import model.jdbcLoginDAO;

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
	private TableColumn<String, Integer> identificador;
	@FXML
	private TableColumn<String, String> nombre;
	@FXML
	private TableColumn<String, String> contraseña;
	@FXML
	private TableColumn<String, String> rol;

	private ObservableList<LoginDTO> itemsTable;
	private jdbcLoginDAO base;
	
	public GestionUsuariosController() {
		this.base= new jdbcLoginDAO();
	}

	@FXML
	private void Añadir(ActionEvent event) {
		LoginDTO l = new LoginDTO(Integer.parseInt(identificadorInput.getText()), nombreInput.getText(), contraseñaInput.getText(), rolInput.getText());
		if(!identificadorInput.getText().equals("") && !nombreInput.getText().equals("") && !contraseñaInput.getText().equals("") && !rolInput.getText().equals("")) 
		{
			base.Añadir(l);
			itemsTable.add(l);
			identificador.setCellValueFactory(new PropertyValueFactory("Identificador"));
			nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
			contraseña.setCellValueFactory(new PropertyValueFactory("Contraseña"));
			rol.setCellValueFactory(new PropertyValueFactory("Rol"));
			
		}

					
	}
	@FXML
    private void Eliminar(ActionEvent event) {
		LoginDTO seleccion = tabla.getSelectionModel().getSelectedItem();
		base.Eliminar(seleccion);
		tabla.getItems().remove(seleccion);

		
			}

	@FXML
    private void Modificar(ActionEvent event) {
		LoginDTO l = new LoginDTO(Integer.parseInt(identificadorInput.getText()), nombreInput.getText(), contraseñaInput.getText(), rolInput.getText());
		base.Modificar(l);
		
		
	}



}