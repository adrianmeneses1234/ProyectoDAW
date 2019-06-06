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
/**Declaracion de la clase GestionSoftwareController
 * 
 * @author Adrian y Samuel
 *@version 06/06/19
 */
public class GestionSoftwareController implements Initializable {
	 //declaracion de los atributos privados
		/**
		 * Declaracion de los atributos privados de FXML
		 * 
		 */
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
	private Button anyadir;
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
	/**
	    * Declaracion de los atributos privados de la clase que no corresponden con
	    * el FXML y llamar a la clase jdbcSoftwareDAO
	    */
	private ObservableList<SoftwareDTO> itemsTable;
	
	private int posicionS;
	 /**
     * Creacion del constructor por defecto de la clase
     */
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
	 /**
     * Creacion del metodo AnyadirSoftware donde al hacer click se realiza la acción de 
     * recoger los datos de sus respectivos TextFields y crea un objeto SoftwareDTO en el cual quedará 
     * guardado en el SQL y la tabla TableView con SetItems.
     * @param event tipo ActionEvent
     */
	
	@FXML
	private void AnyadirSoftware(ActionEvent event) {
				
					SoftwareDTO d=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),LicenciaInput.getText(),caducidadInput.getText(),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
					
					
					
						if(!codigoInput.getText().equals("") && !nombreInput.getText().equals("") && !descripcionInput.getText().equals("") && !versionInput.getText().equals("") && !LicenciaInput.getText().equals("") && !caducidadInput.getText().equals("") && !precioInput.getText().equals("") && !unidadesInput.getText().equals("")) 
						{
							baseSoft.AnyadirSoftware(d);
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
	/**Creacion del metodo EliminarSoftware donde se selecciona un objeto de la tabla
     * y al hacer click en el boton event se elimina el objeto del SQL y de la tabla
     * 
     * @param event tipo ActionEvent
     */
	@FXML
	private void EliminarSoftware(ActionEvent event) {
			
		
				SoftwareDTO seleccion = tabla.getSelectionModel().getSelectedItem();
				baseSoft.EliminarSoftware(seleccion);
				tabla.getItems().remove(seleccion);
				
	
		}
	 /**Creacion del metodo ModificarSoftware en el cual coge los datos recogidos en los 
     * TextFields y si coinciden el codigo se modifican los demas parametros del objeto
     * SoftwareDTO. Estas modificaciones se guardan en la tabla Tableview y en el SQL
     * 
     * @param event tipo ActionEvent
     */
	@FXML
	private void ModificarSoftware(ActionEvent event) {
			//SoftwareDTO seleccion =  tabla.getSelectionModel().getSelectedItem();
			
			//codigoInput=tabla.getSelectionModel().getSelectedItem().getCodigo();
			
			SoftwareDTO AUX=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),LicenciaInput.getText(),caducidadInput.getText(),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
			baseSoft.modificarSoftware(AUX);
			itemsTable.set(posicionS,AUX);
		}
	/**
	 * Creacion del metodo sumar en el cual al hacer click en el boton se añade +1 al Integer unidades en el TextField unidadesInput
	 * @param event tipo ActionEvent
	 */
	@FXML
	private void sumar(ActionEvent event) {
		SoftwareDTO AUX=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),LicenciaInput.getText(),caducidadInput.getText(),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
		unidadesInput.clear();
		AUX.sumar();
		unidadesInput.setText(Integer.toString(AUX.getUnidades()));
		
	}
	/**
	 * Creacion del metodo restar en el cual al hacer click en el boton se resta 1 al Integer unidades en el TextField unidadesInput
	 * @param event tipo ActionEvent
	 */
	@FXML
	private void restar(ActionEvent event) {
		SoftwareDTO AUX=new SoftwareDTO(Integer.parseInt(codigoInput.getText()),nombreInput.getText(),descripcionInput.getText(),versionInput.getText(),LicenciaInput.getText(),caducidadInput.getText(),Integer.parseInt(precioInput.getText()),Integer.parseInt(unidadesInput.getText()));
		unidadesInput.clear();
		AUX.restar();
		unidadesInput.setText(Integer.toString(AUX.getUnidades()));

	}
	 /**
	    * El constructor ListChangeListener recoge un objeto SoftwareDTO y sus datos varian dependiendo del seleccionado
	    * llamando al metodo ponerSoftwareSeleccionado
	    */
	private final ListChangeListener<SoftwareDTO> selectorTablaSoftware =
			new ListChangeListener<SoftwareDTO>() {
				@Override
				public void onChanged(ListChangeListener.Change<? extends SoftwareDTO> c) {
					ponerSoftwareSeleccionado();
				}
				
		};
		 /**
		    * El metodo getTablaSoftwareSeleccionada recoge un elemento SoftwareDTO selecionado de la tabla y
		    * si no hay elementos SoftwareDTO en la tabla devuelve null
		    * @return SoftwareDTO competicionSeleccionada or null
		    */
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
		/**
		 * El metodo ponerSoftwareSeleccionado recoge los datos del SoftwareDTO recogido del metodo seleccion descrito
		 * anteriormente y pone sus datos en sus respectivos TextFields
		 */
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
	  /**Creacion del metodo Atras en el cual al dar al boton se activa el evento
     * en el cual llama al FXML guardado en el package view y monta una nueva ventana 
     * con el nuevo FXML cerrando la ventana anterior en el proceso.
     * @param event tipo ActionEvent
     * @throws IOException lanza la excepcion de IOController
     */

	@FXML
	private void Atras(ActionEvent event) throws IOException {
		Parent log =  FXMLLoader.load(getClass().getResource("/view/Selector_Inventario.fxml"));
	    Scene principal = new Scene(log);
	    Stage PrimaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    PrimaryStage.hide(); 
	    PrimaryStage.setScene(principal);
	    PrimaryStage.show();  



	}
	/**
     * Creacion del metodo Limpiar en el cual limpia los Textfields .
     * @param event tipo ActionEvent
     * @throws IOException lanza la excepcion de IOController
     */
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

	/**
	 * El metodo mostrar recoge los datos de la tabla Software de nuestro SQL, crea objetos SoftwareDTO con esos datos
	 *  y los pega al TableView tabla
	 */
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
	/**
	  * El metodo initialize recoge los datos que queremos mostrar al
	  * entrar en el controlador GestionSoftwareController
	  */
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