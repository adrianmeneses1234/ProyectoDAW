package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.cell.PropertyValueFactory;
import model.jdbcLoginDAO;

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
	private jdbcLoginDAO base;
	private Statement statement;
	private Connection conexion;
	private ResultSet rs;
	
	@FXML
	private void Añadir(ActionEvent event) {
				 
		 try {
			conexion = base.getConnection();
			statement = conexion.createStatement();
			rs = statement.executeQuery("INSERT INTO Hardware (codigo, nombre, descripcion, año, precio, unidades)"
					+ " VALUES ( "+"'"+codigoInput.getText() +","+nombreInput.getText()+","+ descripcionInput.getText()+","+ añoInput.getText()+","+ precioInput+","+ unidadesInput.getText()+"'");
			
			while(rs.next()) {
				if(!codigoInput.getText().equals("") && !nombreInput.getText().equals("")&& !descripcionInput.getText().equals("")&& !añoInput.getText().equals("")&& !precioInput.getText().equals("")&& !unidadesInput.getText().equals("")) {
					itemsTable.add(new HardwareDTO(Integer.parseInt(codigoInput.getText()), nombreInput.getText(), descripcionInput.getText(), Integer.parseInt(añoInput.getText()), Integer.parseInt(precioInput.getText()), Integer.parseInt(unidadesInput.getText())));
					codigo.setCellValueFactory(new PropertyValueFactory("Codigo"));
					nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
					descripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
					año.setCellValueFactory(new PropertyValueFactory("Año"));
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
private void Eliminar(ActionEvent event) {
			try {
				base.getConnection();
				statement = conexion.createStatement();
				HardwareDTO seleccion = tabla.getSelectionModel().getSelectedItem();
				rs = statement.executeQuery("DELETE FROM Hardware"					
				+ " WHERE "+"'"+seleccion +"'");
				tabla.getItems().remove(seleccion);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
private void Modificar(ActionEvent event) {
		base.getConnection();
	}

	

}
