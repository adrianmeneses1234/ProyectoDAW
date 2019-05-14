package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	private jdbcLoginDAO base;
	private Statement statement;
	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
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

	@FXML
	private void Añadir(ActionEvent event) {
		
		try {
			conexion=base.getConnection();
			statement = conexion.createStatement();
			rs = statement.executeQuery("INSERT INTO Usuarios (identificador,nombre,contraseña,rol)"
					+" VALUES ("+"'"+identificadorInput.getText()+","+nombreInput.getText()+","+contraseñaInput.getText()+","+rolInput.getText()+"'");
			while(rs.next()) {
				if(!identificadorInput.getText().equals("") && !nombreInput.getText().equals("") && !contraseñaInput.getText().equals("") && !rolInput.getText().equals("")) 
				{
					itemsTable.add(new LoginDTO(Integer.parseInt(identificadorInput.getText()),nombreInput.getText(),contraseñaInput.getText(),rolInput.getText()));
					identificador.setCellValueFactory(new PropertyValueFactory("Identificador"));
					nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
					contraseña.setCellValueFactory(new PropertyValueFactory("Contraseña"));
					rol.setCellValueFactory(new PropertyValueFactory("Rol"));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	@FXML
    private void Eliminar(ActionEvent event) {
		try {
			base.getConnection();
			statement = conexion.createStatement();
			LoginDTO seleccion = tabla.getSelectionModel().getSelectedItem();
			rs= statement.executeQuery("Delete FROM Usuarios"+" WHERE "+"'"+seleccion+"'");
			tabla.getItems().remove(seleccion);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
    private void Modificar(ActionEvent event) {
		
	}



}
