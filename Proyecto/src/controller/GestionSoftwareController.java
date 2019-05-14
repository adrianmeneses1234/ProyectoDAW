package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class GestionSoftwareController {
	private jdbcLoginDAO base;
	private Statement statement;
	private Connection conexion;
	private PreparedStatement ps;
	private ResultSet rs;
	
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
			
				
				try {
					conexion = base.getConnection();
					statement = conexion.createStatement();
					rs = statement.executeQuery("INSERT INTO software (codigo,nombre,descripcion,version,licencia,caducidad,precio,unidades)"
							+" VALUES ("+"'"+codigoInput.getText()+","+nombreInput.getText()+","+descripcionInput.getText()+","+versionInput.getText()+","+licenciaInput.getText()+","+caducidadInput.getText()+","+precioInput.getText()+","+unidadesInput.getText()+"'");
						
					while(rs.next()) {
						if(!codigoInput.getText().equals("") && !nombreInput.getText().equals("") && !descripcionInput.getText().equals("") && !versionInput.getText().equals("") && !licenciaInput.getText().equals("") && !caducidadInput.getText().equals("") && !precioInput.getText().equals("") && !unidadesInput.getText().equals("")) 
						{
							itemsTable.add(new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),licenciaInput.getText(),Integer.parseInt(caducidadInput.getText()),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText())));
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

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						}
	@FXML
	private void EliminarSoftware(ActionEvent event) {
			
			try {
				base.getConnection();
				statement = conexion.createStatement();
				SoftwareDTO seleccion = tabla.getSelectionModel().getSelectedItem();
				rs= statement.executeQuery("Delete FROM Software"+" WHERE "+"'"+seleccion+"'");
				tabla.getItems().remove(seleccion);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	@FXML
	private void ModificarSoftware(ActionEvent event) {
			
		}


}