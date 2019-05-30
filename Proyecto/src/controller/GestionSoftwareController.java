package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import dto.HardwareDTO;
import dto.SoftwareDTO;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.conexion;
import model.jdbcSoftwareDAO;

public class GestionSoftwareController implements Initializable {
	
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
	private TextField LicenciaInput;
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
	private Button atras;
	@FXML
	private Button mas;
	@FXML
	private Button menos;
	@FXML
	private Button limpiar;


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
	
	private int posicionS;
	
	public GestionSoftwareController() {
		this.baseSoft = new jdbcSoftwareDAO();
		this.tabla= new TableView<SoftwareDTO>();
		this.itemsTable= FXCollections.observableArrayList(new SoftwareDTO());
		this.codigo= new TableColumn<String,Integer>();
		this.nombre= new TableColumn<String,String>();
		this.descripcion= new TableColumn<String,String>();
		this.version= new TableColumn<String,String>();
		this.licencia=new TableColumn<String,String>();
		this.caducidad= new TableColumn<String,Integer>();
		this.precio=new TableColumn<String,Integer>();
		this.unidades= new TableColumn<String,Integer>();
		
	}

	
	@FXML
	private void AñadirSoftware(ActionEvent event) {
				
					SoftwareDTO d=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),LicenciaInput.getText(),caducidadInput.getText(),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
					
					
					
						if(!codigoInput.getText().equals("") && !nombreInput.getText().equals("") && !descripcionInput.getText().equals("") && !versionInput.getText().equals("") && !LicenciaInput.getText().equals("") && !caducidadInput.getText().equals("") && !precioInput.getText().equals("") && !unidadesInput.getText().equals("")) 
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
							tabla.setItems(itemsTable);
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
			
			SoftwareDTO AUX=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),LicenciaInput.getText(),caducidadInput.getText(),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
			baseSoft.modificarSoftware(AUX);
			itemsTable.set(posicionS,AUX);
		}
	
	@FXML
	private void sumar(ActionEvent event) {
		SoftwareDTO AUX=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),LicenciaInput.getText(),caducidadInput.getText(),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
		unidadesInput.clear();
		AUX.sumar();
		unidadesInput.setText(Integer.toString(AUX.getUnidades()));
		
	}
	@FXML
	private void restar(ActionEvent event) {
		SoftwareDTO AUX=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),LicenciaInput.getText(),caducidadInput.getText(),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
		unidadesInput.clear();
		AUX.restar();
		unidadesInput.setText(Integer.toString(AUX.getUnidades()));

	}
	private final ListChangeListener<SoftwareDTO> selectorTablaSoftware =
			new ListChangeListener<SoftwareDTO>() {
				@Override
				public void onChanged(ListChangeListener.Change<? extends SoftwareDTO> c) {
					ponerSoftwareSeleccionado();
				}
				
		};

		public SoftwareDTO getTablaSoftwareSeleccionada() {
			if(tabla != null) {
				List<SoftwareDTO> TABLA = tabla.getSelectionModel().getSelectedItems();
				if(TABLA.size() == 1) {
					final SoftwareDTO competicionSeleccionada = TABLA.get(0);
					return competicionSeleccionada;
				}
			}
			return null;
			
		}
		
	private void ponerSoftwareSeleccionado() {
		final SoftwareDTO s = getTablaSoftwareSeleccionada();
		posicionS = itemsTable.indexOf(s);
		
		if(s != null) {
			codigoInput.setText(Integer.toString(s.getCodigo()));
			nombreInput.setText(s.getNombre());
			descripcionInput.setText(s.getDescripcion());
			versionInput.setText(s.getVersion());
			LicenciaInput.setText(s.getLicencia());
			caducidadInput.setText(s.getCaducidad());
			precioInput.setText(Integer.toString(s.getPrecio()));
			unidadesInput.setText(Integer.toString(s.getUnidades()));
			
			
			
		}
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
	@FXML
	private void Limpiar(ActionEvent event) throws IOException {
		codigoInput.clear();
		nombreInput.clear();
		descripcionInput.clear();
		versionInput.clear();
		LicenciaInput.clear();
		caducidadInput.clear();
		precioInput.clear();
		unidadesInput.clear();
	}

	
	public void mostrar() {
		PreparedStatement ps = null;
		
		try {
			ps = conexion.getInstance().getConnection().prepareStatement("SELECT * FROM Software");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				itemsTable.add(new SoftwareDTO(rs.getInt("CodigoSW"), rs.getString("Nombre"),rs.getString("Descripcion"), rs.getString("Version"), rs.getString("Licencia"), rs.getString("Caducidad"), rs.getInt("Precio"), rs.getInt("Unidades")));
				tabla.setItems(itemsTable);
				
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		codigo.setCellValueFactory(new PropertyValueFactory("Codigo"));
		nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
		descripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
		version.setCellValueFactory(new PropertyValueFactory("Version"));
		licencia.setCellValueFactory(new PropertyValueFactory("Licencia"));
		caducidad.setCellValueFactory(new PropertyValueFactory("Caducidad"));
		precio.setCellValueFactory(new PropertyValueFactory("Precio"));
		unidades.setCellValueFactory(new PropertyValueFactory("Unidades"));
		mostrar();
		
		final ObservableList<SoftwareDTO> tablaSel = tabla.getSelectionModel().getSelectedItems();
		tablaSel.addListener(selectorTablaSoftware);

	}




}